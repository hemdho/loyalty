package com.hem.loyalty.web.controller;

import java.security.Principal;
import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.auth.model.User;
import com.hem.loyalty.dto.OrderDto;
import com.hem.loyalty.dto.UserData;
import com.hem.loyalty.event.OnOrderCreatedEvent;
import com.hem.loyalty.model.Order;
import com.hem.loyalty.service.OrderServiceImpl;

@RestController
@CrossOrigin
public class OrderController {
	@Autowired
	OrderServiceImpl orderService;
	@PostMapping("/loyalty/order")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public String createOrder(@RequestBody OrderDto orderDto,Principal principal) {
		User user = new User(principal.getName());
		orderDto.setUser(new UserData(user.getId()));
		Order order =orderDto.toOrder();
		order.setCreatedDate(OffsetDateTime.now());
		
		Order order_ = orderService.createOrder(order);
		
		return "order Created";
	}
}
