package com.hem.loyalty.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.InitBinder;
import com.hem.common.util.MyDateTimeFomatter;
import com.hem.loyalty.dto.GeneralSpendingRuleDto;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.GeneralSpendingEarningRule;

@RestController
public class EarningRuleController {

	@Autowired
	EarningRuleService earnigRuleService;
	
	
	@Autowired
	private MyDateTimeFomatter mydateTimeFormatter;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(mydateTimeFormatter.getDateFormatter(), true));
		
	}
	
	
	@PostMapping("/admin/earningRule/generalSpending")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public GeneralSpendingEarningRule createGeneralSpendingRule(@RequestBody GeneralSpendingRuleDto generalSpendingRuleDto) {
		System.out.println(generalSpendingRuleDto);
	//	System.out.println(earningRuleDto);
		return earnigRuleService.createGeneralSpendingEarningRule(generalSpendingRuleDto);
	}
}
