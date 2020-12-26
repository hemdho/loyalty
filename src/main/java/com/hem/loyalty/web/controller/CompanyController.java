package com.hem.loyalty.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.model.User;
import com.hem.auth.repository.UserRepository;
import com.hem.common.util.GenericDataTableResponse;
import com.hem.loyalty.dto.CompanyDto;
import com.hem.loyalty.dto.SiteDto;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Site;
import com.hem.loyalty.service.ICompanyService;
@CrossOrigin
@RestController
public class CompanyController {

	@Autowired
	ICompanyService companyService;
	
	@Autowired 
	UserRepository userRepo;
	
	@PostMapping("/admin/company")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public CompanyDto createCompany(@RequestBody CompanyDto companyDto,Principal principal) {
		
		User user=userRepo.findByUsername(principal.getName()).get();
		System.out.println(" User " + user.getEmail());
		Company company=companyService.create(companyDto.toCompany(),user);
		System.out.println(company.toString());
		return new CompanyDto(company);
		//return new Company();
	}
	@PostMapping("/admin/site")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public SiteDto createSite(@RequestBody SiteDto siteDto,Principal principal) {
		System.out.println(" Reached here inside site");
		User user=userRepo.findByUsername(principal.getName()).get();	
		Site site=companyService.addSite(siteDto.getCompanyId(), siteDto.toSite(), user);
		System.out.println(" Reached here end of site");
		return new SiteDto(site);
		//return new Company();
	}
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping("/admin/site")
	public GenericDataTableResponse<SiteDto> getSites(){
		List<Site> sites=companyService.getSites("6504e09e-11d9-49f8-b024-3392eaeefdd2"); 
		GenericDataTableResponse<SiteDto> response=new GenericDataTableResponse<SiteDto>();
		ArrayList<SiteDto> sitesA=new ArrayList<SiteDto>();
		sites.forEach(site->sitesA.add(new SiteDto(site)));
		response.setData(sitesA);
		response.setPage(1);
		response.setPageSize(10);
		response.setTotalPages(1);
		response.setTotalRecords(sites.size());
		return response;
		
		
	}
	@GetMapping("/admin/company")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public GenericDataTableResponse<CompanyDto> getCompany() {
		List<Company> companies= companyService.getAllCompanies();
		List<CompanyDto> companyDtos=new ArrayList<CompanyDto>();
		if(Objects.nonNull(companies)&& companies.size()>0) {
			companies.forEach(company->companyDtos.add(new CompanyDto(company)));
		}
		GenericDataTableResponse<CompanyDto> response=new GenericDataTableResponse<CompanyDto>();
		response.setData(companyDtos);
		response.setPage(1);
		
		response.setPageSize(10);
		response.setTotalPages(1);
		response.setTotalRecords(companies.size());
		return response;
	}
	
}
