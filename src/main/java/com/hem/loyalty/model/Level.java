package com.hem.loyalty.model;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomDateSerializer;

@Document(value = "levels")
public class Level {
   
	@Id
	private String name;
	private String description;
	private boolean enabled;
	
	private boolean rewardStatus;
	private String rewardName;
	private String rewardValue;
	private int minimumPoints;
	private String rewardCode;
	
	private boolean specialRewardStatus;
	private String specialRewardName;
	private String specialRewardValue;
	private Date specialRewardStartDate;
	private Date specialRewardEndDate;
	private String specialRewardCode;
	@DBRef(lazy = true)	
	private Company company;
	
	@CreatedDate
	@JsonSerialize(using = CustomDateSerializer.class)
	private String createdDate;
	
	
	
	
	@DBRef(lazy = true)
	private User user;
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isRewardStatus() {
		return rewardStatus;
	}
	public void setRewardStatus(boolean rewardStatus) {
		this.rewardStatus = rewardStatus;
	}
	public String getRewardName() {
		return rewardName;
	}
	public void setRewardName(String rewardName) {
		this.rewardName = rewardName;
	}
	public String getRewardValue() {
		return rewardValue;
	}
	public void setRewardValue(String rewardValue) {
		this.rewardValue = rewardValue;
	}
	public int getMinimumPoints() {
		return minimumPoints;
	}
	public void setMinimumPoints(int minimumPoints) {
		this.minimumPoints = minimumPoints;
	}
	public String getRewardCode() {
		return rewardCode;
	}
	public void setRewardCode(String rewardCode) {
		this.rewardCode = rewardCode;
	}
	public boolean isSpecialRewardStatus() {
		return specialRewardStatus;
	}
	public void setSpecialRewardStatus(boolean specialRewardStatus) {
		this.specialRewardStatus = specialRewardStatus;
	}
	public String getSpecialRewardName() {
		return specialRewardName;
	}
	public void setSpecialRewardName(String specialRewardName) {
		this.specialRewardName = specialRewardName;
	}
	public String getSpecialRewardValue() {
		return specialRewardValue;
	}
	public void setSpecialRewardValue(String specialRewardValue) {
		this.specialRewardValue = specialRewardValue;
	}
	
	public Date getSpecialRewardStartDate() {
		return specialRewardStartDate;
	}
	public void setSpecialRewardStartDate(Date specialRewardStartDate) {
		this.specialRewardStartDate = specialRewardStartDate;
	}
	public Date getSpecialRewardEndDate() {
		return specialRewardEndDate;
	}
	public void setSpecialRewardEndDate(Date specialRewardEndDate) {
		this.specialRewardEndDate = specialRewardEndDate;
	}
	public String getSpecialRewardCode() {
		return specialRewardCode;
	}
	public void setSpecialRewardCode(String specialRewardCode) {
		this.specialRewardCode = specialRewardCode;
	}
	
		
	
}
