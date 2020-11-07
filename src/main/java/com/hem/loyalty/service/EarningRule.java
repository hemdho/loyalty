package com.hem.loyalty.service;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public abstract class EarningRule {
	
	private String name;
    private String description;
    private boolean status;
    private int priority;
    private Activity activity;
    @DBRef
    private Set<Segment> segments;
    @DBRef
    private Set<Level> levels;
    private String type;
    

	 public abstract String getId(); 
     public abstract void setId(String id);


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


	
	/* public boolean getStatus();
	 public void setStatus(boolean status);
	 public int getPriority();
	 public void setPriority(int priority);
	 public String getName();
	 public String getDescription();*/
	 
	 
}
