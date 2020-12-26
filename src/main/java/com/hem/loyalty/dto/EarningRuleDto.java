package com.hem.loyalty.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.auth.model.User;
import com.hem.common.util.CustomDateDeserializer;
import com.hem.common.util.CustomDateSerializer;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Level;
import com.hem.loyalty.service.Activity;
import com.hem.loyalty.service.EarningRule;
import com.hem.loyalty.service.Segment;

public class EarningRuleDto {
	private String id;
	private String name;
    private String description;
    private boolean enabled;
    private int priority;
    private List<Segment> segments;
    private List<Level> levels;
    
    private boolean allTime;
    private String type;
    
    private Date createdDate;
    
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using=CustomDateSerializer.class)
    private Date startDate;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using=CustomDateSerializer.class)
    
	private Date endDate;
	private String siteId;
	
    private String companyId;	
    
    private UserData user;
	
	public EarningRuleDto() {
		
	}
	public EarningRuleDto(EarningRule earningRule) {
		setAllTime(earningRule.getActivity().isAllTime());
		setDescription(earningRule.getDescription());
		setEnabled(earningRule.isStatus());
		setStartDate(earningRule.getActivity().getStartDate());
		setEndDate(earningRule.getActivity().getEndDate());
		setId(earningRule.getId());
		setPriority(earningRule.getPriority());
		setLevels(earningRule.getLevels());
		setName(earningRule.getName());
		setSegments(earningRule.getSegments());
		setCompanyId(earningRule.getCompany().getId());
		setType(earningRule.getType());
		setUser(new UserData(earningRule.getUser()));
		setType(earningRule.getType());
		
	}
	public EarningRule toEarningRule(EarningRule rule) {
		rule.setDescription(getDescription());
		rule.setName(getName());
		Activity activity=new Activity();
		activity.setAllTime(isAllTime());
		activity.setStartDate(getStartDate());
		activity.setEndDate(getEndDate());
		rule.setActivity(activity);
		rule.setCreatedDate(getCreatedDate());
		rule.setId(getId());
		getLevels().stream().forEach(level->System.out.println(level.getName()));
		rule.setLevels(getLevels());
		rule.setPriority(getPriority());
		rule.setUser(new User(getUser().getUserId()));
		rule.setCompany(new Company(getCompanyId()));
		rule.setType(getType());
		rule.setStatus(isEnabled());
		rule.setSegments(getSegments());
			return rule;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public List<Segment> getSegments() {
		return segments;
	}
	public void setSegments(List<Segment> segments) {
		this.segments = segments;
	}
	public List<Level> getLevels() {
		return levels;
	}
	public void setLevels(List<Level> levels) {
		this.levels = levels;
	}
	public boolean isAllTime() {
		return allTime;
	}
	public void setAllTime(boolean allTime) {
		this.allTime = allTime;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	@Override
	public String toString() {
		return "EarningRuleDto [id=" + id + ", name=" + name + ", description=" + description + ", enabled=" + enabled
				+ ", priority=" + priority + ", segments=" + segments + ", levels=" + levels + ", allTime=" + allTime
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", siteId=" + siteId + "]";
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	
	
	
	
    
    
}
