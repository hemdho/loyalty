package com.hem.loyalty.web.controller;

import java.security.Principal;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.model.User;
import com.hem.auth.service.IUserService;
import com.hem.common.util.GenericDataTableResponse;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.dto.CustomerDto;
import com.hem.loyalty.dto.CustomerOverviewDto;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.ICustomerService;
@CrossOrigin
@RestController
public class CustomerController {
	
	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private EarningRuleService earningRuleService;
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/customer")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public CustomerDto registerCustomer(@RequestBody CustomerDto customer,Principal principal) {
		
		User user= userService.findUserByUsername(principal.getName());
		Customer customer_= customerService.create(customer.toCustomer(), user);
		return new CustomerDto(customer_);
		
		
	}
	
	@GetMapping("/customers")
	@ResponseBody
	public GenericDataTableResponse<CustomerOverviewDto> getAll(@RequestParam String companyId,@RequestParam int pageNo,@RequestParam int pageSize) {
		Page<Customer> customers=customerService.getAllCustomers(companyId, pageNo, pageSize);
		GenericDataTableResponse<CustomerOverviewDto> customerOVerviewResponse = new GenericDataTableResponse<CustomerOverviewDto>();
		if(customers!=null && customers.hasContent() && customers.getTotalElements()>0) {
			
			customerOVerviewResponse.setData(customers.getContent().stream().map(customer->new CustomerOverviewDto(customer)).collect(Collectors.toList()));
			customerOVerviewResponse.setPage(pageNo);
			customerOVerviewResponse.setPageSize(pageSize);
			customerOVerviewResponse.setTotalPages(customers.getTotalPages());
			customerOVerviewResponse.setTotalRecords(customers.getTotalElements());
			return customerOVerviewResponse;
		}
		/*earningRuleService.createEarningRule();
		return customerService.findAll(); */
		return customerOVerviewResponse;
	}
	@GetMapping("/customer/{id}")
	@ResponseBody
	public CustomerDto getCustomer(@PathVariable Long id) {
		System.out.println(" id " + id);
		Customer customer =customerService.findById(id);
		if(customer!=null) return new CustomerDto(customer);
		throw new RecordNotFoundException("Cannot find given customer");
	}
	
	@PutMapping("/customer/{id}")
	@ResponseBody
	public String updateCustomer(@PathVariable Long id,@RequestBody CustomerDto customerDto) {
		 customerService.update(customerDto.toCustomer());
		 return "Customer Updated";
	}
}
