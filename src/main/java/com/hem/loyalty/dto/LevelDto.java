package com.hem.loyalty.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateSerializer;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Level;

public class LevelDto {
	
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
	
	private String  companyId;
	
	
	@JsonSerialize(using = CustomDateSerializer.class)
	private String createdDate;
	
	
	
	
	@DBRef
	private UserData user;
	
	
	public LevelDto() {
		
	}
	
	public Level toLevel() {
		Level level=new Level();
		Company company = new Company();
		company.setId(getCompanyId());
		level.setCompany(company);
		level.setCreatedDate(getCreatedDate());
		level.setDescription(getDescription());
		level.setEnabled(isEnabled());
		level.setMinimumPoints(getMinimumPoints());
		level.setName(getName());
		level.setRewardCode(getRewardCode());
		level.setRewardName(getRewardName());
		level.setRewardStatus(isRewardStatus());
		level.setRewardValue(getRewardValue());
		level.setSpecialRewardCode(getSpecialRewardCode());
		level.setSpecialRewardEndDate(getSpecialRewardEndDate());
		level.setSpecialRewardStartDate(getSpecialRewardStartDate());
		level.setSpecialRewardName(getSpecialRewardName());
		level.setSpecialRewardStatus(isSpecialRewardStatus());
		level.setSpecialRewardValue(getSpecialRewardValue());
		return level;
	}
	
	
	public LevelDto(Level level) {
		
		setCompanyId(level.getCompany().getId());
		setCreatedDate(level.getCreatedDate());
		setDescription(level.getDescription());
		setEnabled(level.isEnabled());
		setMinimumPoints(level.getMinimumPoints());
		setName(level.getName());
		setRewardCode(level.getRewardCode());
		setRewardName(level.getRewardName());
		setRewardStatus(level.isRewardStatus());
		setRewardValue(level.getRewardValue());
		setSpecialRewardCode(level.getSpecialRewardCode());
		setSpecialRewardEndDate(level.getSpecialRewardEndDate());
		setSpecialRewardStartDate(level.getSpecialRewardStartDate());
		setSpecialRewardName(level.getSpecialRewardName());
		setSpecialRewardStatus(level.isSpecialRewardStatus());
		setSpecialRewardValue(level.getSpecialRewardValue());
		
	}
	
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
	
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
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
