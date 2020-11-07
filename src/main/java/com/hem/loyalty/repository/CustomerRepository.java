package com.hem.loyalty.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

	
	Optional<Customer> findByEmailid(String emailid);
	Optional<Customer> findByMobileNo(String mobileNo);
	
}
