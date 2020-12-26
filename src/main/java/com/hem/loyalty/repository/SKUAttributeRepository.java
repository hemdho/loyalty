package com.hem.loyalty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hem.loyalty.model.SKUAttribute;

public interface SKUAttributeRepository extends MongoRepository<SKUAttribute,String> {
 
	@Query(" from SKUAttribute s,s.company comp where s.key=:key and comp.id=:companyId ")
	List<SKUAttribute> findAllByKeyAndCompanyId(@Param("key") String key,@Param("companyId") String companyId);
}
