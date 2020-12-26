package com.hem.loyalty.dto;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.SKUAttribute;

public class SKUAttributesDto {

	
	private String id;
	private String key;
	private String value;
	private String companyId;

	public SKUAttributesDto() {
		
	}
	public SKUAttributesDto(SKUAttribute skuAttribute) {
		setId(skuAttribute.getId());
		setKey(skuAttribute.getKey());
		setValue(skuAttribute.getValue());
		setCompanyId(skuAttribute.getCompany().getId());
	}
	public SKUAttribute toSKUAttribute() {
		SKUAttribute skuAttribute=new SKUAttribute();
		skuAttribute.setId(getId());
		skuAttribute.setKey(getKey());
		skuAttribute.setValue(getValue());
		Company company = new Company();
		company.setId(getCompanyId());
		return skuAttribute;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
}
