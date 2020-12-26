package com.hem.loyalty.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hem.loyalty.model.SKU;
import com.hem.loyalty.model.SKUAttribute;
import com.hem.loyalty.repository.SKUAttributeRepository;
import com.hem.loyalty.repository.SKURepository;

@Service
public class SKUService {
   
	
	@Autowired
	SKURepository skuRepository;
	
	@Autowired
	SKUAttributeRepository skuAttributeRepository;
	
	
	
	public SKU create(SKU sku ) {
		sku.setId(UUID.randomUUID().toString());
		skuRepository.save(sku);
		return sku;
	}
	
	public SKU update(SKU sku) {
		sku=skuRepository.save(sku);
		return sku;
	}
	public SKUAttribute createAttribute(SKUAttribute attribute) {
		attribute.setId(UUID.randomUUID().toString());
		attribute=skuAttributeRepository.save(attribute);
		return attribute;
	}
	public List<SKUAttribute> getSKUAttributes(String key,String companyId){
		return skuAttributeRepository.findAllByKeyAndCompanyId(key,companyId);
	}
	public List<SKU> getSKU(String sku,String description,String companyId){
		if(sku!=null && !sku.isEmpty() ) return getSKU(sku,companyId);
		if(description!=null && !description.isEmpty()) getSKUByDescription(description, companyId);
		List<SKU> skuList= skuRepository.findByCompanyId(companyId);
		return skuList;
	}
	public List<SKU> getSKU(String sku,String companyId  ){
		return skuRepository.findBySKU( "^"+ sku, companyId);
	}
	public List<SKU> getSKUByDescription(String desc,String companyId){
		return skuRepository.findByDescription( "^"+desc, companyId);
	}
	
}
