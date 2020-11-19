package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hem.loyalty.model.Company;

public interface CompanyRepository extends MongoRepository<Company,String>{

	
	
	
	@Query(value="{'id':?0 }",fields= "{'enabled': 1}")
	Company getStatus(@Param("id") String id);
}
