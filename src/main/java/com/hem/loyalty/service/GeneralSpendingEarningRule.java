package com.hem.loyalty.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hem.loyalty.model.Customer;
import com.hem.loyalty.model.Level;
import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.OrderItem;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.repository.CustomerRepository;

@Document
public class GeneralSpendingEarningRule extends EarningRule implements EarningRuleEvent<Order> {

	@Id
	private String id;
	private int pointValue;

	private Set<String> excludedSKU;

	private Set<SKULabel> labelsIncluded;
	private Set<SKULabel> labelExcluded;

	private double minOrderValue;
	private boolean isLastRule;

	@Autowired
	CustomerRepository customerRepo;

	public GeneralSpendingEarningRule() {
		setType("General Spending");
	}

	@Override
	public Points calculatePoints(Order t) {
	   	
		List<OrderItem> items=t.getItems();
        Map<String,OrderItem> itemMap=new LinkedHashMap<String,OrderItem>();
		double orderTotal=0d;
	    
		for(OrderItem item:items) {
		//	orderTotal += item.getRate() * item.getQuantity();
			itemMap.put(item.getSKU(), item);
		}
		if(!getExcludedSKU().isEmpty()) {
			getExcludedSKU().stream().forEach(sku->{
				if(itemMap.containsKey(sku)) itemMap.remove(sku);
			});
		}
		orderTotal=itemMap.values().stream()
				.mapToDouble(orderItem-> orderItem.getRate() * orderItem.getQuantity())
				.sum();
		Points points = new Points();
		points.setCustomerId(t.getCustomer().getId());
		points.setOrderDate(t.getOrderDate());
		points.setRules( this.getName());
		
		//points.setCompany(company);
       		
		if(orderTotal<minOrderValue) {
		    int totalPoints = (int)(orderTotal * getPointValue());
			points.setPoints( totalPoints );
		}
		return points;
	}

	@Override
	public boolean isCriteriaMatches(Order t) {
		Customer c = t.getCustomer();
		// check whether customer is exist or not
		Optional<Customer> customerOptional = customerRepo.findByMobileNo(t.getCompanyId(),  c.getMobileNo());
		if (customerOptional.isEmpty()) {
			// customer doesn't exist;
			// if customer is new and level in rule is applicable to all return true else
			// return false;
			return true;
		} else {
			List<Level> levels = customerOptional.get().getLevels();
			for (Level level : levels) {
				if (getLevels().contains(level)) {
					return true;
				}
			}
		}
		return false;
	}

	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public Set<String> getExcludedSKU() {
		return excludedSKU;
	}

	public void setExcludedSKU(Set<String> excludedSKU) {
		this.excludedSKU = excludedSKU;
	}

	public Set<SKULabel> getLabelsIncluded() {
		return labelsIncluded;
	}

	public void setLabelsIncluded(Set<SKULabel> labelsIncluded) {
		this.labelsIncluded = labelsIncluded;
	}

	public Set<SKULabel> getLabelExcluded() {
		return labelExcluded;
	}

	public void setLabelExcluded(Set<SKULabel> labelExcluded) {
		this.labelExcluded = labelExcluded;
	}

	public double getMinOrderValue() {
		return minOrderValue;
	}

	public void setMinOrderValue(double minOrderValue) {
		this.minOrderValue = minOrderValue;
	}

	public boolean isLastRule() {
		return isLastRule;
	}

	public void setLastRule(boolean isLastRule) {
		this.isLastRule = isLastRule;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;

	}

}
