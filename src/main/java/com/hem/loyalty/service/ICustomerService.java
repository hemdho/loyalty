package com.hem.loyalty.service;

import org.springframework.data.domain.Page;

import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.Points;

public interface ICustomerService extends MyService<Customer,Long > {
   
	Page<Customer> getAllCustomers(String companyId,int pageNo,int limit);
	Customer findByMobileNo(String companyId,String mobileNo);
	Customer findByEmail(String companyId,String email);
	void savePointsToCustomer(Points points);
	
	
}
