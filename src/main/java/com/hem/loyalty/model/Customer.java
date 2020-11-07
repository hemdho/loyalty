package com.hem.loyalty.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hem.auth.model.User;
import com.hem.loyalty.service.Level;

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
	 private Set<Level> levels;
	 
	 
	 
	 public Set<Level> getLevels() {
		return levels;
	}

	public void setLevels(Set<Level> levels) {
		this.levels = levels;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@CreatedBy
	 private User user;
	 @CreatedDate
	// @JsonSerialize(using=CustomDateTimeSerializer.class)
	 private Date createdDate;
	 
	 private Set<Address> addresses=new HashSet<Address>();

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

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}
	 
	 
	
}
