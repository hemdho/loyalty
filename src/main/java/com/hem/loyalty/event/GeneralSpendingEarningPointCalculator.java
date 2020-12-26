package com.hem.loyalty.event;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.OrderItem;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.service.EarningRule;
import com.hem.loyalty.service.GeneralSpendingEarningRule;

public class GeneralSpendingEarningPointCalculator implements IEarningPointCalculator<Order> {

	@Override
	public int calculatePoints(Order t, EarningRule earningRule) {
		GeneralSpendingEarningRule gRule=(GeneralSpendingEarningRule) earningRule;
		List<OrderItem> items=t.getItems();
        Map<String,OrderItem> itemMap=new LinkedHashMap<String,OrderItem>();
		double orderTotal=0d;
	    
		for(OrderItem item:items) {
		//	orderTotal += item.getRate() * item.getQuantity();
			itemMap.put(item.getSKU(), item);
		}
		if(!gRule.getExcludedSKU().isEmpty()) {
			gRule.getExcludedSKU().stream().forEach(sku->{
				if(itemMap.containsKey(sku)) itemMap.remove(sku);
			});
		}
		orderTotal=itemMap.values().stream()
				.mapToDouble(orderItem-> orderItem.getRate() * orderItem.getQuantity())
				.sum();
		Points points = new Points();
		
		
		//points.setCompany(company);
		int totalPoints=0;	
		if(t.getTotalAmount()>=gRule.getMinOrderValue()) {
		     totalPoints = (int)(orderTotal * gRule.getPointValue());
		    totalPoints=(int) totalPoints/gRule.getPointValuePerCurrency();
			points.setPoints( totalPoints );
		}
		return  totalPoints;

		
	}

	@Override
	public boolean isCriteriaMatches(Order t, EarningRule earningRule) {
		
		return false;
	}

	
	

}
