package com.hem.loyalty.dto;

import java.io.Serializable;

import com.hem.auth.model.User;

public class UserData implements Serializable{
	private String userId;
	private String name;
	
	public UserData() {
		
	}
	
	public UserData(User user) {
		setUserId(user.getId());
		setName(user.getFirstName() + user.getLastName() + "(" +  user.getUsername() +")");
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
