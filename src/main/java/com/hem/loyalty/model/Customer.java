package com.hem.loyalty.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomOffsetDateTimeSerializer;

@Document(collection = "customers")
public class Customer {
	@Transient
	public static final String SEQUENCE_NAME = "customer_sequence";
	@Id
	private Long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private Date dob;
	private Date anniversary;
	private String gender;
	private String mobileNo;
	private String email;
	@DBRef
	private Level level;
	@DBRef(lazy = true)
	private Company company;
	private boolean enabled;
    @DBRef(lazy = true)
	@CreatedBy
	private User user;
	@CreatedDate
	@JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime createdDate;

	private List<Address> addresses = new ArrayList<Address>();

	@DBRef(lazy=true)
	private CustomerLoyaltyInfo customerLoyaltyInfo;
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	} 
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
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

	public CustomerLoyaltyInfo getCustomerLoyaltyInfo() {
		return customerLoyaltyInfo;
	}

	public void setCustomerLoyaltyInfo(CustomerLoyaltyInfo customerLoyaltyInfo) {
		this.customerLoyaltyInfo = customerLoyaltyInfo;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(Date anniversary) {
		this.anniversary =  anniversary ;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;

	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", dob=" + dob + ", anniversary=" + anniversary + ", gender=" + gender + ", mobileNo="
				+ mobileNo + ", email=" + email + ", level=" + level + ", company=" + company + ", enabled=" + enabled
				+ ", user=" + user + ", createdDate=" + createdDate + ", addresses=" + addresses + "]";
	}
	

}
