package com.hem.loyalty.event;

import com.hem.loyalty.model.Points;
import com.hem.loyalty.service.EarningRule;

public interface IEarningPointCalculator<T> {
  
	int calculatePoints(T t,EarningRule earningRule);
	boolean isCriteriaMatches(T t,EarningRule earningRule);
}
