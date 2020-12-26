package com.hem.loyalty.web.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.loyalty.dto.SKUAttributesDto;
import com.hem.loyalty.dto.SKUDto;
import com.hem.loyalty.model.SKU;
import com.hem.loyalty.model.SKUAttribute;
import com.hem.loyalty.service.SKUService;
@CrossOrigin
@RestController
public class SKUController {
   
	@Autowired
	SKUService skuService;
	
	@GetMapping("/products/sku")
	@ResponseBody
	public List<SKUDto> getSKUs(@RequestParam String sku, @RequestParam String companyId){
		List<SKU> skuList= skuService.getSKU(sku, null, companyId);
		if(skuList!=null && skuList.size()>0) {
			return skuList.stream().map(sku_->new SKUDto(sku_)).collect(Collectors.toList());
		}
		return null;
	}
	
	@GetMapping("/products/skuAttributes")
	@ResponseBody
	public List<SKUAttributesDto> getSKUAttributes(@RequestParam String key,@RequestParam String companyId){
		List<SKUAttribute> skuAttributes=skuService.getSKUAttributes(key, companyId);
		if(skuAttributes.size()>0) {
			return skuAttributes.stream().map(skuAttribute_-> new SKUAttributesDto(skuAttribute_)).collect(Collectors.toList());
		}
		return null;
	}
	
	@PostMapping("/products/skuAttributes")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public SKUAttributesDto createSKUAttributes(@RequestBody SKUAttributesDto attributeDto) {
		SKUAttribute skuAttribute= skuService.createAttribute(attributeDto.toSKUAttribute());
		return new SKUAttributesDto(skuAttribute);
	}
	@PostMapping("/products/sku")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public SKUDto createSKU(@RequestBody SKUDto skuDto) {
		SKU sku=skuService.create(skuDto.toSKU());
		return new SKUDto(sku);
	}
}
