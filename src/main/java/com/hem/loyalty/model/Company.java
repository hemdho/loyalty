package com.hem.loyalty.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomDateTimeSerializer;

@Document
public class Company {
	
	@Id
	private String id;
	private String name;
	private boolean enabled;
	private String phoneNo;
	private String mobileNo;
	private String email;
	private String contactPerson;
	private String currency;
	@DBRef
	@CreatedBy
	private User user;
	@CreatedDate
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date createdDate;
	@Version
	private int version;
	private String code;
	
	Set<Address> addresses=new HashSet<Address>();
	Set<Site> sites=new HashSet<Site>();
	
	
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

	
	public Set<Site> getSites() {
		return sites;
	}
	public void setSites(Set<Site> sites) {
		this.sites = sites;
	}
	public Set<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", enabled=" + enabled + ", phoneNo=" + phoneNo + ", mobileNo="
				+ mobileNo + ", email=" + email + ", contactPerson=" + contactPerson + ", currency=" + currency
				+ ", user=" + user + ", createdDate=" + createdDate + ", version=" + version + ", code=" + code + "]";
	}

	
}
