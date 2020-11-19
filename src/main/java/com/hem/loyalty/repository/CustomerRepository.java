package com.hem.loyalty.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hem.loyalty.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer,String>{

	@Query("select c from Customer c,c.company comp where c.emailId=:emailId and comp.id=:companyId ")
	Optional<Customer> findByEmailid(@Param("companyId")String companyId,@Param("emaildId")String emailid);
	Optional<Customer> findByMobileNo(String companyId,String mobileNo);
	
}
