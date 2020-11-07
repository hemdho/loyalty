package com.hem.loyalty.model;

import java.util.Map;

public class OrderItem {

	private String id;
	private String itemId;
	private String itemType;
	private int quantity;
	private double rate;
	private String SKU;
	private Map<String,String> attributes;
	
	
	public String getSKU() {
		return SKU;
	}
	public void setSKU(String sku) {
		this.SKU = sku;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
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
	
}
