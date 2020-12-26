package com.hem.loyalty.dto;

import java.util.ArrayList;
import java.util.List;

import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.SKU;
import com.hem.loyalty.model.SKUAttribute;

public class SKUDto {
	
    private String id;    
    private String sku;
    private String  companyId;
    private List<SKUAttributesDto> attributes;
    private String description;
    

    public SKUDto() {
    	
    }
    
    public SKUDto(SKU sku) {
    	setId(sku.getId());
    	setCompanyId(sku.getCompany().getId());
    	setDescription(sku.getDescription());
    	setSku(sku.getSku());
    	if(sku.getAttributes()!=null && sku.getAttributes().size()>0) {
    			List<SKUAttributesDto> skuAttributes = new ArrayList<SKUAttributesDto>();
    			sku.getAttributes().stream().forEach(skuAttribute->  skuAttributes.add(new SKUAttributesDto(skuAttribute)));
    			setAttributes(skuAttributes);
    	}
    }
    
    public SKU toSKU() {
    	SKU sku=new SKU();
    	sku.setId(getId());
    	sku.setSku(getSku());
    	sku.setCompany(new Company(getCompanyId()));
    	sku.setDescription(getDescription());
    	if(getAttributes()!=null && getAttributes().size()>0) {
    		List<SKUAttribute> skuAttributes_ = new ArrayList<SKUAttribute>();
    		getAttributes().stream().forEach(skuAttributeDto->skuAttributes_.add(skuAttributeDto.toSKUAttribute()) );
    		sku.setAttributes(skuAttributes_);
    		
    	}
    	return sku;
    }	
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
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public List<SKUAttributesDto> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<SKUAttributesDto> attributes) {
		this.attributes = attributes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    

}
