package com.hem.loyalty.dto;

import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hem.auth.model.User;
import com.hem.loyalty.model.Address;

public class AddressDto {
 
	
	private Long id;
	private String street1;
	private String street2;
	private String street3;
	private String area;
	private String city;
	private String state;
	private String postcode;
	private boolean enabled;
	
	
	public AddressDto() {
		
	}
	public AddressDto(Address address) {
		setArea(address.getArea());
		setCity(address.getCity());
        setCreatedDate(address.getCreatedDate());
        setEnabled(address.isEnabled());
        setId(address.getId());
        setPostcode(address.getPostcode());
        setState(address.getState());
        setStreet1(address.getStreet1());
        setStreet2(address.getStreet2());
        setStreet3(address.getStreet3());
        if(address.getUser()!=null)
        setUser(new UserData(address.getUser().getId()));
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	 private UserData user;
	 @CreatedDate
	// @JsonSerialize(using=CustomDateTimeSerializer.class)
	 @JsonIgnore
	 private Date createdDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStreet1() {
		return street1;
	}
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	public String getStreet2() {
		return street2;
	}
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	public String getStreet3() {
		return street3;
	}
	public void setStreet3(String street3) {
		this.street3 = street3;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Address toAddress() {
		Address address=new Address();
		address.setArea(getArea());
		address.setCity(getCity());
		if(user!=null && user.getUserId()!=null) address.setUser(new User(user.getUserId()));
		address.setCreatedDate(getCreatedDate());
		address.setEnabled(enabled);
		address.setId(id);
		address.setPostcode(postcode);
		address.setState(state);
		address.setStreet1(street1);
		address.setStreet2(street2);
		address.setStreet3(street3);
		return address;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", street1=" + street1 + ", street2=" + street2 + ", street3=" + street3
				+ ", area=" + area + ", city=" + city + ", state=" + state + ", postcode=" + postcode + ", enabled="
				+ enabled + ", user=" + user + ", createdDate=" + createdDate + "]";
	}
	

}
