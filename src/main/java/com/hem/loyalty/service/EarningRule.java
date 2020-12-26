package com.hem.loyalty.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hem.auth.model.User;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Level;
@Document
public abstract class EarningRule {
	
	private String name;
    private String description;
    private boolean status;
    private int priority;
    private Activity activity;
    @DBRef
    private List<Segment> segments;
    @DBRef
    private List<Level> levels;
    private String type;
    private Date createdDate;
    @DBRef(lazy = true)
    private User user;
    @DBRef(lazy = true)
    private Company company;
    
	 public abstract String getId(); 
     public abstract void setId(String id);


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


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Activity getActivity() {
		return activity;
	}


	public void setActivity(Activity activity) {
		this.activity = activity;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public int getPriority() {
		return priority;
	}


	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	
	/* public boolean getStatus();
	 public void setStatus(boolean status);
	 public int getPriority();
	 public void setPriority(int priority);
	 public String getName();
	 public String getDescription();*/
	 
	 
}
