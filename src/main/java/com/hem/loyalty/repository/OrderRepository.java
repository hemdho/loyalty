package com.hem.loyalty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.model.Order;

public interface OrderRepository extends MongoRepository<Order, String>{
 
	List<Order> findAllByStatus(String status);
}
