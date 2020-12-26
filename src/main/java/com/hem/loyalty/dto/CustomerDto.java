package com.hem.loyalty.dto;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomDateDeserializer;
import com.hem.common.util.CustomDateSerializer;
import com.hem.common.util.CustomOffsetDateTimeSerializer;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.Level;

public class CustomerDto {
	private long id;
	private String firstName;
	private String lastName;
	@JsonSerialize(using=CustomDateSerializer.class)
	@JsonDeserialize(using=CustomDateDeserializer.class)
	private Date dob;
	private Date   anniversary;
	private String gender;
	private String mobileNo;
	private String email;
	private String companyId;
	private boolean enabled;
	private UserData user;
	@JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime createdDate;
	private Level level;
	
	private List<AddressDto> addresses;
	

	public CustomerDto() {
		
	}
	public CustomerDto(Customer customer) {
		setAnniversary(customer.getAnniversary());
		setDob(customer.getDob());
		setLevel(customer.getLevel());
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
			setAddresses(customer.getAddresses().stream().map(address-> new AddressDto(address)).collect(Collectors.toList()));
		}
	}
	
	
	public Customer     toCustomer(){
			Customer customer =new Customer();
			Company company = new Company();
			company.setId(getCompanyId());
	        customer.setCompany(company);
			customer.setAnniversary(getAnniversary());
			customer.setDob(getDob());
			customer.setLevel( getLevel());
			customer.setCreatedDate(getCreatedDate());
			customer.setEmail(getEmail());
			customer.setEnabled(isEnabled());
			customer.setFirstName(getFirstName());
			customer.setLastName(getLastName());
			customer.setGender(getGender());
			customer.setId(getId());
			customer.setMobileNo(getMobileNo());
			if(getAddresses()!=null && getAddresses().size()>0) {
				customer.setAddresses(getAddresses().stream().map(addressDto-> addressDto.toAddress()).collect(Collectors.toList()));
			}
			
			if(user!=null && user.getUserId()!=null) {
				customer.setUser(new User(user.getUserId()));
			}
				
			
			
			return customer;
	}
	public List<AddressDto> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressDto> addresses) {
		this.addresses = addresses;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String string) {
		this.firstName = string;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public OffsetDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(OffsetDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	public Date getAnniversary() {
		return anniversary;
	}
	public void setAnniversary(Date anniversary) {
		this.anniversary = anniversary;
	}

}
