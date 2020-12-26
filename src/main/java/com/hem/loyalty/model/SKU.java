package com.hem.loyalty.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (value="skus")
public class SKU {
     @Id
     private String id;
     @Indexed
     private String sku;
     @Indexed
     private String description;
     
     @DBRef(lazy = true)
     private Company company;
     @Indexed
     @DBRef(lazy = true)
     private List<SKUAttribute> attributes;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public List<SKUAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<SKUAttribute> attributes) {
		this.attributes = attributes;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
     
     
}
