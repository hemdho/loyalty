package com.hem.loyalty.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateSerializer;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Site;

public class SiteDto {

	private String id;	
	private String name;
	private String code;
	private UserData user;
	@JsonSerialize(using=CustomDateSerializer.class)	
	private Date createdDate;
	private Address address;
	private boolean enabled;
	private String companyId;

	
	public Site toSite() {
		Site site=new Site();
		site.setAddress(getAddress());
		site.setCreatedDate(getCreatedDate());
		site.setEnabled(isEnabled());
		site.setId(getId());
		site.setName(getName());
		site.setCode(getCode());
		return site;
		
	}
	
	public SiteDto() {
		
	}
	public SiteDto(Site site) {
		    
			setAddress(site.getAddress());
			setCreatedDate(site.getCreatedDate());
			setEnabled(site.isEnabled());
			setId(site.getId());
			setName(site.getName());
			setUser(new UserData(site.getUser()));
			setCode(site.getCode());
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
