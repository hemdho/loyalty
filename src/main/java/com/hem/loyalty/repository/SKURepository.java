package com.hem.loyalty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hem.loyalty.model.SKU;

public interface SKURepository extends MongoRepository<SKU,String>{

	
	//@Query(" from SKU s,s.company comp where comp.id=:companyId and s.sku like :sku ")
	@Query("{'company.id': ?1, 'sku': {$regex: ?0 }}")
	List<SKU> findBySKU(String sku,String companyId);
	
//	@Query(" from SKU s,s.company comp where comp.id=:companyId and s.description like :desc order by s.description")
	@Query("{'company.id': ?1, 'description': {$regex: ? 0}}")
	List<SKU> findByDescription(@Param("desc") String desc,@Param("companyId") String companyId);
	//@Query(" select s from SKU s,s.company comp where comp.id=:companyId order by s.description")
	//@Query("{'company' :{'$ref' : 'company' , '$id' : ?0}}")
	@Query("{'company.id' : ?0 }")//  {'$ref' : 'company' , '$id' : ?0}}")
	List<SKU> findByCompanyId( String companyId );
}
