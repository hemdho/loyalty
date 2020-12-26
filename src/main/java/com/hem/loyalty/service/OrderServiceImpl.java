package com.hem.loyalty.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.hem.exception.InActiveRecordFoundException;
import com.hem.exception.RecordNotFoundException;
import com.hem.loyalty.event.OnOrderCreatedEvent;
import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.Site;
import com.hem.loyalty.repository.OrderRepository;
@Service
public class OrderServiceImpl {

	@Autowired
	OrderRepository orderRepository;
	@Autowired
	ICustomerService customerService;
	@Autowired
	ICompanyService companyService;

	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	

	@Autowired
	MongoTemplate template;
	
	public Order createOrder(Order order) {
		
		
		
	    companyService.validateCompanyAndSite(order.getCompany().getId(), order.getSite().getId());
		Customer customer=customerService.findByMobileNo(order.getCompany().getId(), order.getCustomer().getMobileNo());
		if(Objects.isNull(customer)) customer=customerService.create(order.getCustomer(), order.getUser());
		order.setStatus("Created");
		
		order.setCustomer(customer);
		order.setCompany(customer.getCompany());
		Order order_= orderRepository.save(order);
		
		eventPublisher.publishEvent(new OnOrderCreatedEvent(order_));
		return order_;
	}
	
	public List<Order> getPendingForPointCalculationsOrders(){
		return orderRepository.findAllByStatus("Created");
	}
	public Order updateOrder(Order order) {
		return template.save(order);
	}
}
