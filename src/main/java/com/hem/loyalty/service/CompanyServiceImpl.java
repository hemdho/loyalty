package com.hem.loyalty.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hem.auth.model.User;
import com.hem.auth.repository.UserRepository;
import com.hem.common.util.SequenceGeneratorService;
import com.hem.exception.InActiveRecordFoundException;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Site;
import com.hem.loyalty.repository.CompanyRepository;
import com.hem.loyalty.repository.SiteRepository;

@Service
public class CompanyServiceImpl implements ICompanyService {
	@Autowired
	CompanyRepository companyRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	SiteRepository siteRepo;

	@Autowired
	private SequenceGeneratorService seqService;

	@Override
	public Company findById(String s) {
		Optional<Company> company = companyRepo.findById(s);
		if (company.isPresent())
			return company.get();
		throw new RecordNotFoundException("Company not found");
	}

	@Override
	public boolean isExist(String id) {
		return companyRepo.existsById(id);
	}

	@Override
	public boolean isActive(String id) {
		Company company=companyRepo.getStatus(id);
		if(company!=null) return company.isEnabled();
		throw new RecordNotFoundException(" Company not found ");
	}

	@Override
	public Company create(Company company, User user) {
		try {
			company.setId(UUID.randomUUID().toString());
			company.setEnabled(true);
			company.getAddresses().stream().forEach(address -> prepareNewAddress(address, user));
			company.getSites().stream().forEach(site -> prepareNewSite(site, user));
			company.setCreatedDate(new Date());
			company.setUser(user);
			company = companyRepo.save(company);
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		/*
		 * customer.setId(String.valueOf(seqService.generateSequence(Customer.
		 * SEQUENCE_NAME)));
		 * customer.getAddresses().stream().forEach(address->address.setId(seqService.
		 * generateSequence(Address.SEQUENCE_NAME))); customerRepo.sa
		 */

	}

	@Override
	public Company update(Company t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getSites(String companyId) {
		Optional<Company> company = companyRepo.findById(companyId);
		if (!company.isEmpty()) {
			List<Site> sites = new ArrayList<Site>();
			if (company.get().getSites() != null && company.get().getSites().size() > 0) {
				sites.addAll(company.get().getSites());

			}
			return sites;
		} else {
			return new ArrayList<Site>();
		}

	}

	public String getUUID() {
		return UUID.randomUUID().toString();
	}

	@Override
	public void validate(String id) {
		if (!isExist(id))
			throw new RecordNotFoundException("Cannot find company");
		if (!isActive(id))
			throw new InActiveRecordFoundException("Company is not Active");
		// return true;
	}

	@Override
	public Site addSite(String companyId, Site site, User user) {
		validate(companyId);
		// site.setId(getUUID());
		prepareNewSite(site, user);
		Company company = findById(companyId);
		prepareNewAddress(site.getAddress(), user);
		company.getSites().add(site);
		Company comp = companyRepo.save(company);
		return comp.getSites().stream().filter(site_ -> site.getId().equalsIgnoreCase(site.getId())).findAny()
				.orElse(null);
	}

	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	private void prepareNewAddress(Address address, User user) {
		address.setId(seqService.generateSequence(Site.SEQUENCE_NAME));
		address.setUser(user);
		address.setCreatedDate(new Date());
		address.setEnabled(true);
	}

	private void prepareNewSite(Site site, User user) {
		site.setId(UUID.randomUUID().toString());
		site.setEnabled(true);
		site.setCreatedDate(new Date());
		site.setUser(user);
	}

	@Override
	public void addAddress(String companyId, Address address, User user) {
		validate(companyId);
		Company company = findById(companyId);
		prepareNewAddress(address, user);
		company.getAddresses().add(address);
		companyRepo.save(company);
	}

	@Override
	public void removeSite(String companyId, final String siteId) {
		validate(companyId);
		Company company = findById(companyId);
		Site site = company.getSites().stream().filter(site_ -> site_.getId().equalsIgnoreCase(siteId)).findAny()
				.orElse(null);
		if (Objects.isNull(site))
			new RecordNotFoundException("Cannot find the site");
		if (!site.isEnabled())
			new InActiveRecordFoundException("Site is Already inactive");
		site.setEnabled(false);
		companyRepo.save(company);

	}

	@Override
	public boolean isSiteExist(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSiteActive(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Site getSite(String companyId, String siteId) {
		return siteRepo.getSite(companyId, siteId);
	}

	@Override
	public void validateCompany(String companyId) {
		if(!isActive(companyId)) throw new InActiveRecordFoundException("Company is not active");

	}

	@Override
	public void validateCompanyAndSite(String companyId, String siteId) {
		validateCompany(companyId);
		Company company = findById(companyId);
		Site site = company.getSites().stream().filter(site_->site_.getId().equals(siteId)).findFirst().orElse(null);
		if(site==null) throw new RecordNotFoundException(" Site not found");
		if(!site.isEnabled()) throw new InActiveRecordFoundException("Site is not active");
	}

}
