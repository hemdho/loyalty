package com.hem.loyalty.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.hem.auth.model.User;
import com.hem.exception.InActiveRecordFoundException;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.repository.CustomerRepository;

public class CustomerServiceImpl implements ICustomerService{

	@Autowired
	ICompanyService companyService;
	@Autowired
	CustomerRepository customerRepo;
	
	@Override
	public Customer findById(Long s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(Long t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Customer create(Customer customer, User user) {
		companyService.validate(customer.getCompany().getId());
		
		return null;
	}

	private void validate(Customer customer) {
		companyService.validate(customer.getCompany().getId());
		if((Objects.nonNull(customer.getId())) && !isExist(customer.getId())) throw new RecordNotFoundException("Customer not found");
		if(!isActive(customer.getId())) throw new InActiveRecordFoundException("Customer is Inactive");
	}
	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActive(Long t) {
		// TODO Auto-generated method stub
		return false;
	}

}
