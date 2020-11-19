package com.hem.auth.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hem.auth.model.User;

public class UserTableDto {
 
	private String id;
	private String username;
	private String email;
	private String role;
	private boolean enabled;
	
	private Date createdDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean getEnabled() {
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
	public UserTableDto getUserTableDto(User user) {
		UserTableDto userTableDto=new UserTableDto();
		userTableDto.setEmail(user.getEmail());
		userTableDto.setEnabled(user.isEnabled());
		userTableDto.setId(user.getId());
		userTableDto.setUsername(user.getUsername());
		userTableDto.setRole("admin");
		return userTableDto;
	}
	
	public List<UserTableDto> getUserTableDtoList(List<User> users){
		List<UserTableDto> userTableDtoList = new ArrayList<UserTableDto>();
		users.stream().forEach(user->userTableDtoList.add(getUserTableDto(user)));
		return userTableDtoList;
	}
	
	
}
