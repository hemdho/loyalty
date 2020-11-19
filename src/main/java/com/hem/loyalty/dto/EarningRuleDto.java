package com.hem.loyalty.dto;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateDeserializer;
import com.hem.common.util.CustomDateSerializer;
import com.hem.loyalty.model.Level;
import com.hem.loyalty.service.Segment;

public class EarningRuleDto {
	private String id;
	private String name;
    private String description;
    private boolean enabled;
    private int priority;
    private Set<Segment> segments;
    private Set<Level> levels;
    
    private boolean allTime;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using=CustomDateSerializer.class)
    private Date startDate;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    @JsonSerialize(using=CustomDateSerializer.class)
    
	private Date endDate;
	private String siteId;
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
	public Set<Segment> getSegments() {
		return segments;
	}
	public void setSegments(Set<Segment> segments) {
		this.segments = segments;
	}
	public Set<Level> getLevels() {
		return levels;
	}
	public void setLevels(Set<Level> levels) {
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
	
	
	
	
    
    
}
