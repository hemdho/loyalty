package com.hem.loyalty.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateSerializer;
import com.hem.common.util.CustomDateTimeSerializer;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Company;

public class CompanyDto {
	private String id;
	private String name;
	private String code;	
	private boolean enabled;
	@JsonSerialize(using=CustomDateSerializer.class)
	private Date createdDate;
	private String phoneNo;
	private String mobileNo;
	private String email;
	private String contactPerson;
	private String currency;
	private UserData user;
	private List<Address> addresses;
	
	
	public CompanyDto(Company company) {
    	setId(company.getId());
    	setName(company.getName());
    	setEnabled(company.isEnabled());
    	setCode(company.getCode());
    	setContactPerson(company.getContactPerson());
    	setCreatedDate(company.getCreatedDate());
    	setCurrency(company.getCurrency());
    	setEmail(company.getEmail());
    	setMobileNo(company.getMobileNo());
    	setPhoneNo(company.getPhoneNo());
    	if(company.getUser()!=null) {
    		setUser(new UserData(company.getUser()));
    	}
    	if(!company.getAddresses().isEmpty()) {
    		List<Address> addresses=new ArrayList<Address>();
			addresses.addAll(getAddresses());
			setAddresses(addresses);
    	}
    }
	
	public CompanyDto() {
		
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
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public Company toCompany() {
		Company company=new Company();
		company.setId(getId());
		company.setName(getName());
		company.setEnabled(isEnabled());
		company.setCreatedDate(getCreatedDate());
		company.setCode(getCode());
		company.setEmail(getEmail());
		company.setMobileNo(getMobileNo());
		company.setPhoneNo(getPhoneNo());
		
		if(Objects.nonNull(getAddresses()) && !getAddresses().isEmpty()) {
			Set<Address> addresses=new HashSet<Address>();
			addresses.addAll(getAddresses());
			company.setAddresses(addresses);
		}
			
			
		return company;
	}
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
}
