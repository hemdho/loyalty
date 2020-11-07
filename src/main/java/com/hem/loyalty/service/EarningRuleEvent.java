package com.hem.loyalty.service;

import com.hem.loyalty.model.Points;

public interface EarningRuleEvent<T> {
  
	Points calculatePoints(T t);
	boolean isCriteriaMatches(T t);
}
