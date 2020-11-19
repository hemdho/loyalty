package com.hem.loyalty.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomDateTimeSerializer;

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
	private Date annyversaryDate;
	private String gender;
	private String mobileNo;
	private String emailid;
	@DBRef
	private List<Level> levels;
	@DBRef
	private Company company;
	private boolean enabled;

	@CreatedBy
	private User user;
	@CreatedDate
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	private Date createdDate;

	private List<Address> addresses = new ArrayList<Address>();

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

	public List<Level> getLevels() {
		return levels;
	}

	public void setLevels(List<Level> levels) {
		this.levels = levels;
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

	public Date getAnnyversaryDate() {
		return annyversaryDate;
	}

	public void setAnnyversaryDate(Date annyversaryDate) {
		this.annyversaryDate = annyversaryDate;
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

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

}
