package com.hem.loyalty.event;

import org.springframework.context.ApplicationEvent;

import com.hem.loyalty.model.Order;

public class OnOrderCreatedEvent extends ApplicationEvent{
    private Order order;
	
	public OnOrderCreatedEvent(Order order) {
		super(order);
		this.order=order;
		// TODO Auto-generated constructor stub
	}

	public Order getOrder() {
		return order;
	}
}
