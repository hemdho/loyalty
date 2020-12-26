package com.hem.loyalty.service;

import java.util.List;
import java.util.Set;

import com.hem.auth.model.User;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Site;

public interface ICompanyService extends MyService<Company, String> {

	
	public List<Site> getSites(String companyId);
	
	public Site addSite(String companyId,Site site,User user);
	public void removeSite(String companyId,final String siteId);
	public boolean isSiteExist(String id);
	public boolean isSiteActive(String id);
	public void addAddress(String companyId,Address address,User user);
    public void validate(String companyId);
    public List<Company> getAllCompanies();
    public Site getSite(String companyId,String siteId);
    void validateCompany(String companyId);
	void validateCompanyAndSite(String companyId,String site);
}
