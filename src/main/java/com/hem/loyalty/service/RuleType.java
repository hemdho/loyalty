package com.hem.loyalty.service;

import com.hem.loyalty.model.Points;

public abstract class RuleType<T> {
	private String name;
    T t;
	public RuleType(T t) {
		this.t=t;
	}
	
	public abstract Points calculatePoints() ;
	
}
