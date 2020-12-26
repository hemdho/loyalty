package com.hem.loyalty.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hem.loyalty.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,Long>{

	@Query("{'company.id':?0,'email': ?1 } ")
	Optional<Customer> findByEmail(String companyId,String email);
	@Query("{'company.id': ?0, 'mobileNo': ?1 }")
	Optional<Customer> findByMobileNo(String companyId,String mobileNo);
	@Query("{'company.id': ?0  }")
	Page<Customer> findAllByCompanySortByFirstName(String companyId,   Pageable pageable);
}
