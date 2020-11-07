package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.service.EarningRule;

public interface EarningRuleRepository  extends MongoRepository<EarningRule,String>{

	
}
