package com.hem.loyalty.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hem.loyalty.model.Order;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.ICustomerService;
import com.hem.loyalty.service.OrderServiceImpl;
import com.hem.loyalty.service.PointsService;
@Component
public class OrderCreatedListener implements ApplicationListener<OnOrderCreatedEvent> {

	@Autowired
	OrderServiceImpl orderService;

	
	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private EarningRuleService earningRuleService;
	
	@Autowired
	private PointsService pointsService;

	
	@Override
	public void onApplicationEvent(OnOrderCreatedEvent event) {
		System.out.println("Order Processing Event Started");
        OrderPointCalculator calculator = new OrderPointCalculator(event.getOrder(),customerService,earningRuleService,pointsService);
        calculator.process();
       
		Order order = event.getOrder();
		order.setStatus("Processed");
		orderService.updateOrder(order);
		System.out.println("Order Processing Event ended");
	}
}
