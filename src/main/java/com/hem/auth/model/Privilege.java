package com.hem.auth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "privilleges")
public class Privilege {

	@Id
	private Integer id;
	private String name;
//	
	public Privilege(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public Privilege() {
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
