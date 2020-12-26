package com.hem.loyalty.model;

import java.time.OffsetDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomOffsetDateTimeSerializer;

@Document (value = "customerLoyaltyInfos")
public class CustomerLoyaltyInfo {
	
    @Id	
    private String id;
    
    @DBRef(lazy = true)
    private Customer customer;
    
    @DBRef(lazy=true)
    private Company company;
	
    private int totalPointsEarned;
	private int totalPointsRedeemed;
	private int availablePoints;
	@JsonSerialize(using = CustomOffsetDateTimeSerializer.class)
	private OffsetDateTime lastTransactionDate;
	
	public int getTotalPointsEarned() {
		return totalPointsEarned;
	}
	public void setTotalPointsEarned(int totalPointsEarned) {
		this.totalPointsEarned = totalPointsEarned;
	}
	public int getTotalPointsRedeemed() {
		return totalPointsRedeemed;
	}
	public void setTotalPointsRedeemed(int totalPointsRedeemed) {
		this.totalPointsRedeemed = totalPointsRedeemed;
	}
	public int getAvailablePoints() {
		return availablePoints;
	}
	public void setAvailablePoints(int availablePoints) {
		this.availablePoints = availablePoints;
	}
	public OffsetDateTime getLastTransactionDate() {
		return lastTransactionDate;
	}
	public void setLastTransactionDate(OffsetDateTime lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	 
	
}
