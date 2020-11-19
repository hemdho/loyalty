package com.hem.auth.model;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hem.common.util.RecordStatus;

@Document(collection="roles")
public class Role {
    @Id
	private String id;
    @NotBlank
    @Size(max = 20)
    private String name;
    
    private boolean enabled;
    
    private Set<Short> privileges;
    
    
    public Role() {
    	
    }
    public Role(String id,String name,Set<Short> privileges) {
    	this.id=id;
    	this.name=name;
    	this.privileges=privileges;
    }
    public Role(String id,String name,Short[] privileges) {
    	this.id=id;
    	this.name=name;
    	this.privileges=new HashSet<Short>();
    	for(Short privilege:privileges) {
    	  this.privileges.add(privilege);
    	}
    	 
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
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public void setPrivileges(Set<Short> privileges) {
		this.privileges = privileges;
	}
	public Set<Short> getPrivileges() {
		return privileges;
	}
	
    
    
}
