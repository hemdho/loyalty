
package com.hem.loyalty.event;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.service.EarningRule;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.ICustomerService;
import com.hem.loyalty.service.PointsService;


public class OrderPointCalculator {

	
	private ICustomerService customerService;
	
	
	private EarningRuleService earningRuleService;
	
	
	private PointsService pointsService;

		
	private Order order;
	public OrderPointCalculator(Order order,ICustomerService customerService,EarningRuleService earningRuleService,PointsService pointsService) {
		this.order = order;
		this.earningRuleService=earningRuleService;
		this.pointsService=pointsService;
		this.customerService=customerService;
	}
	private void prepareForPoints(Points points,String ruleName) {
		points.setCustomer(order.getCustomer());
		points.setSalesMan(order.getSalesMan());
		points.setSite(order.getSite());
		points.setUser(order.getUser());
		points.setCreatedDate(OffsetDateTime.now());
		points.setOrderDate(order.getOrderDate());
		points.setRules( ruleName);
		points.setOrderId(order.getOrderId());
	}
	private EarningRule filterRuleForDateRange(List<EarningRule> rules) {
		EarningRule rule=null;
		if(rules!=null && rules.size()>1 ) {
			EarningRule rule1=rules.stream().filter(rule_->rule_.getActivity().isDateWithingRange()==true && rule_.isStatus()==true).findFirst().orElse(null);
			if(rule1==null) rule=rules.get(0);
			else rule=rule1;
		}else if(rules!=null && rules.size()==1) {
			rule= rules.get(0);
		}
		return rule;
	}
	public void process() {
		final String level= order.getCustomer().getLevel()!=null ? order.getCustomer().getLevel().getName():null;
		
		
		List<EarningRule> earningRules= earningRuleService.getEarningRules(order.getCompany().getId());
		EarningRule rule=null;
		/****IF there is any rules based on given level find it**/
		if(level!=null) { 
			List<EarningRule> rules= earningRules.stream().filter(rule_-> rule_.getLevels()!= null &&  rule_.getLevels().contains(level)).collect(Collectors.toList());
			rule=filterRuleForDateRange(rules);
		}
		if(rule==null || level==null) {
			List<EarningRule> rules=earningRules.stream().filter(rule1 -> ( (rule1.getLevels()==null || rule1.getLevels().size()==0 ) && rule1.isStatus()==true)  ).collect(Collectors.toList());
			rule=filterRuleForDateRange(rules);
		}
			
		
		Points points = new Points();
		
			prepareForPoints(points, null);
			if(rule!=null) {
				String ruleType =rule.getType();
				points.setRules(rule.getName());
				switch(ruleType) {
						case "General Spending":
								GeneralSpendingEarningPointCalculator calulator= new GeneralSpendingEarningPointCalculator();
								int totalPoints =calulator.calculatePoints(order, rule);
								points.setPoints(totalPoints);
		
							      break;
						default: 
							break;
				}
				
			}
			pointsService.create(points);
		}
		
		
		
	}
	
	

/*
 * package com.hem.loyalty.event;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hem.loyalty.model.Order;
import com.hem.loyalty.model.Points;
import com.hem.loyalty.service.EarningRule;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.ICustomerService;
import com.hem.loyalty.service.PointsService;

public class OrderProcesser {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	EarningRuleService earningRuleService;
	
	@Autowired
	PointsService pointsService;
	
	private Order order;
	
	public OrderProcesser(Order order) {
		this.order = order;
	}
	private void prepareForPoints(Points points,String ruleName) {
		points.setCustomer(order.getCustomer());
		points.setSalesMan(order.getSalesMan());
		points.setSite(order.getSite());
		points.setUser(order.getUser());
		points.setCreatedDate(OffsetDateTime.now());
		points.setOrderDate(order.getOrderDate());
		points.setRules( ruleName);
	}
	public void process() {
		final String level=order.getCustomer().getLevel().getName();
		List<EarningRule> earningRules= earningRuleService.getEarningRules(order.getCompany().getId());
		
		if(level!=null) {
			EarningRule rule= earningRules.stream().filter(rule_->rule_.getLevels().contains(level)).findFirst().orElse(null);
			if(rule==null) rule=earningRules.stream().filter(rule1 -> rule1.getLevels()==null || rule1.getLevels().size()==0).findFirst().orElse(null);
			Points points = new Points;
			prepareForPoints(points, null);
			if(rule!=null) {
				String ruleType =rule.getType();
				points.setRules(rule.getName());
				Switch(ruleType){
					case "General Spending":
						            GeneralSpendingEarningPointCalculator calulator= new GeneralSpendingEarningPointCalculator();
						            int totalPoints =calulator.calculatePoints(order, earningRule);
						            points.setPoints(totalPoints);
						             break;
					case default:
				}
			}
		}
		
		
		
	}
	
}
*/
