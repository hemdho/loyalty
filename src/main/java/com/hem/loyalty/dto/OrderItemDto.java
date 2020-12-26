package com.hem.loyalty.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.hem.loyalty.model.OrderItem;

public class OrderItemDto {
	private Long id;
    private String itemId;
    private int quantity;
    private double rate;
    private String sku;
    
    
    public OrderItemDto() {
    	
    }
    public OrderItem toOrderItem() {
    	OrderItem item = new OrderItem();
    	item.setId(getId());
    	item.setItemId(itemId);
    //	item.setItemType(itemType);
    	item.setQuantity(quantity);
    	item.setRate(rate);
    	item.setSKU(sku);
    	if(attributes!=null && attributes.size()>0 ) {
    		item.setAttributes(attributes.stream().map(attributeDto->attributeDto.toSKUAttribute()).collect(Collectors.toList()));
    	}
    	return item;
    }
    
    private List<SKUAttributesDto> attributes;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public String getSku() {
		return sku;
	}
	public void setSKU(String sKU) {
		this.sku = sKU;
	}
	public List<SKUAttributesDto> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<SKUAttributesDto> attributes) {
		this.attributes = attributes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
    
}
