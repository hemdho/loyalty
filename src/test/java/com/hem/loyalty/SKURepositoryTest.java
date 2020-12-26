package com.hem.loyalty;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.hem.loyalty.model.SKU;
import com.hem.loyalty.repository.SKURepository;


@SpringBootTest
@DirtiesContext
@ExtendWith(SpringExtension.class)

public class SKURepositoryTest {
	@Test
	void contextLoads() {
	}

   @Autowired
   SKURepository skuRepository;
	
	//@Autowired
	//EarningRuleService earningRuleService;
	@Test
	public void findByCompanyId() {
		List<SKU> skuList=skuRepository.findByCompanyId("6504e09e-11d9-49f8-b024-3392eaeefdd2");
		System.out.println(skuList.size());
	}
	
	//@Test
	public void createEarningRule() {
		//earningRuleService.createEarningRule();
	}
	
}
