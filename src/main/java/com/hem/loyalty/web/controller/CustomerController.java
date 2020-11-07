package com.hem.loyalty.web.controller;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.common.util.SequenceGeneratorService;
import com.hem.loyalty.model.Address;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.repository.CustomerRepository;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.GeneralSpendingEarningRule;

@RestController
public class CustomerController {
	
	@Autowired
	private SequenceGeneratorService seqService;

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private EarningRuleService earningRuleService;
	
	@PostMapping("/customer")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Customer registerCustomer(Customer customer,Address address) {
		customer.setId(seqService.generateSequence(Customer.SEQUENCE_NAME));
		address.setId(seqService.generateSequence(Address.SEQUENCE_NAME));
		customer.getAddresses().add(address);
		customer.setCreatedDate(new Date());
		address.setCreatedDate(new Date());
		return customerRepo.save(customer);
	}
	
	@GetMapping("/customer")
	@ResponseBody
	public List<Customer> getAll() {
		earningRuleService.createEarningRule();
		return customerRepo.findAll();
	}
	@GetMapping("/customer/{id}")
	public GeneralSpendingEarningRule getCustomer() {
		return earningRuleService.getEarningRule();
	}
}
