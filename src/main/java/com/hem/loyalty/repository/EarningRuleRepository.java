package com.hem.loyalty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hem.loyalty.service.EarningRule;

public interface EarningRuleRepository  extends MongoRepository<EarningRule,String>{
	
	@Query("{'company.id': ?0 }")
	List<EarningRule> findAllByCompany(String companyId);
	
	
}
