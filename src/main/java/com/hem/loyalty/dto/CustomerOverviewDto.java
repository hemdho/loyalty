package com.hem.loyalty.dto;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateTimeSerializer;
import com.hem.common.util.CustomOffsetDateTimeSerializer;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Customer;

public class CustomerOverviewDto {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String mobileNo;
	private String email;
	private String level;
	private String companyId;
	@JsonSerialize(using =CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime createdDate;
	private UserData user;
	private boolean enabled;
	private String area;
	@JsonSerialize(using=CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime lastTransactionDate;
	private int pointsAvailable;
	
	public CustomerOverviewDto(Customer customer) {
		if(customer.getLevel()!=null)
		setLevel(customer.getLevel().getName());
		setCreatedDate(customer.getCreatedDate());
		setEmail(customer.getEmail());
		setEnabled(customer.isEnabled());
		setFirstName(customer.getFirstName());
		setLastName(customer.getLastName());
		setGender(customer.getGender());
		setId(customer.getId());
		setMobileNo(customer.getMobileNo());
		setCompanyId(customer.getCompany().getId());
		setUser(new UserData(customer.getUser()));
		if(customer.getAddresses()!=null && customer.getAddresses().size()>0) {
			Address address_=customer.getAddresses().stream().filter(a->a.isEnabled()).findFirst().orElse(null);
			if(address_!=null) setArea(address_.getArea()); 
			//filter(address_ => address_.isEnabled()==true).collect(Collectors.toList()   ));
		}
		if(customer.getCustomerLoyaltyInfo()!=null) {
			setLastTransactionDate(customer.getCustomerLoyaltyInfo().getLastTransactionDate());
			setPointsAvailable(customer.getCustomerLoyaltyInfo().getAvailablePoints());
			
		}
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public boolean isEnabled() {
		return enabled;
	}



	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}



	public String getArea() {
		return area;
	}



	public void setArea(String area) {
		this.area = area;
	}



	public OffsetDateTime getLastTransactionDate() {
		return lastTransactionDate;
	}



	public void setLastTransactionDate(OffsetDateTime lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}



	 


	public int getPointsAvailable() {
		return pointsAvailable;
	}



	public void setPointsAvailable(int pointsAvailable) {
		this.pointsAvailable = pointsAvailable;
	}
	
	
	
}
