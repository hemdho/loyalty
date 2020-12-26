package com.hem.loyalty.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.hem.auth.model.User;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.Site;

public class OrderDto {
	
	private String orderId;
	private CustomerDto customer;
	private Date orderDate;
	private double orderTotal;
	private String currency;
	private String companyId;
	private String siteId;
	private UserData user;
	private List<OrderItemDto> items;
	private String salesMan;

	
	public Order toOrder() {
		Order order = new Order();
		order.setCustomer(customer.toCustomer());
		
		order.setCompany(new Company(companyId));
		order.getCustomer().setCompany(order.getCompany());
		order.setSite(new Site(siteId));
		order.setTotalAmount(orderTotal);
		order.setUser(new User(user.getUserId()));
		order.setCurrency(currency);
		order.setSalesMan(salesMan);
		order.setOrderDate(orderDate);
		order.setOrderId(orderId);
	
		if(items!=null && items.size()>0) {
			order.setItems(items.stream().map(itemDto->itemDto.toOrderItem()).collect(Collectors.toList()));
		}
		
		return order;
	}
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public UserData getUser() {
		return user;
	}
	public void setUser(UserData user) {
		this.user = user;
	}
	public List<OrderItemDto> getItems() {
		return items;
	}
	public void setItems(List<OrderItemDto> items) {
		this.items = items;
	}
	public String getSalesMan() {
		return salesMan;
	}
	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}
	
}
