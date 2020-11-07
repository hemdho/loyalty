package com.hem.loyalty.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hem.loyalty.repository.EarningRuleRepository;
@Service
public class EarningRuleService {

	@Autowired
	private EarningRuleRepository earningRuleRepo;
	
	
	public void createEarningRule() {
		GeneralSpendingEarningRule earningRule=new GeneralSpendingEarningRule();
		Activity activity=new Activity();
		activity.setAllTime(false);
		activity.setStartDate(new Date());
		activity.setEndDate(new Date());
		earningRule.setActivity(activity);
		earningRule.setDescription("General Spending Rule");
		earningRule.setId(UUID.randomUUID().toString());
		Set<String> excludedSKU = new HashSet<String>();
		excludedSKU.add("123");
		excludedSKU.add("345");
		earningRule.setExcludedSKU(excludedSKU);
		Level level= new Level();
		level.setId(UUID.randomUUID().toString());
		level.setName("GOLD");
		Set<Level> levels=new HashSet<Level>();
		levels.add(level);
		earningRule.setLevels(levels);
		
		earningRule.setMinOrderValue(100d);
		earningRule.setPointValue(1);
		earningRule.setStatus(true);
		earningRule.setPriority(1);
		earningRuleRepo.save(earningRule);
	}
	
	public GeneralSpendingEarningRule getEarningRule() {
		return (GeneralSpendingEarningRule) earningRuleRepo.findById("ce8befdd-f85a-4a2f-90c4-e8e8a0372c0c").get();
	}
	
	
	
}
