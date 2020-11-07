package com.hem.loyalty.service;

import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.Points;

public class AccountCreatedRuleType extends RuleType<Customer>{
    
	public AccountCreatedRuleType(Customer t) {
		super(t);
		
	}

	@Override
	public Points calculatePoints() {
		// TODO Auto-generated method stub
		return null;
	}

}
