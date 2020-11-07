package com.hem.loyalty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hem.loyalty.service.EarningRuleService;

@SpringBootTest
@DirtiesContext
@ExtendWith(SpringExtension.class)
public class EarningRuleTest {

	@Autowired
	EarningRuleService earningRuleService;
	
	
	@Test
	public void createEarningRule() {
		earningRuleService.createEarningRule();
	}
	
}
