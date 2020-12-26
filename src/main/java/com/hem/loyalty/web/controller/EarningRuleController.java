package com.hem.loyalty.web.controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hem.common.util.GenericDataTableResponse;
import com.hem.common.util.MyDateTimeFomatter;
import com.hem.loyalty.dto.EarningRuleDto;
import com.hem.loyalty.dto.GeneralSpendingRuleDto;
import com.hem.loyalty.dto.UserData;
import com.hem.loyalty.service.EarningRule;
import com.hem.loyalty.service.EarningRuleService;
import com.hem.loyalty.service.GeneralSpendingEarningRule;
import com.hem.loyalty.util.MyCustomDateEditor;
@CrossOrigin
@RestController
public class EarningRuleController {

	@Autowired
	EarningRuleService earningRuleService;
	
	
	@Autowired
	private MyDateTimeFomatter mydateTimeFormatter;
	
	@InitBinder
	private void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyCustomDateEditor(mydateTimeFormatter.getDateFormatter(), true));
		
	}
	
	
	@PostMapping("/admin/earningRule/generalSpending")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.CREATED)
	public GeneralSpendingEarningRule createGeneralSpendingRule(@Valid @RequestBody GeneralSpendingRuleDto generalSpendingRuleDto,Principal principal) {
		generalSpendingRuleDto.setUser(new UserData(principal.getName()));
		System.out.println(generalSpendingRuleDto);
	//	System.out.println(earningRuleDto);
		return earningRuleService.createGeneralSpendingEarningRule(generalSpendingRuleDto);
	}
	
	
	@GetMapping("/admin/earningRule/generalSpending/{id}")
	@ResponseBody
	@ResponseStatus(value = HttpStatus.OK)
	public GeneralSpendingRuleDto getGeneralSpendingRule(@PathVariable String id) {
		GeneralSpendingEarningRule rule=earningRuleService.getGeneralSpendingEarningRuleById(id);
		if(rule!=null) {
			return new GeneralSpendingRuleDto(rule);
		}
		return null;
		
	}
	
	@PutMapping("/admin/earningRule/generalSpending/{id}")
	@ResponseStatus(value=HttpStatus.OK)
	@ResponseBody
	public String updateGeneralSpendingRule(@PathVariable String id,@RequestBody GeneralSpendingRuleDto generalSpendingDto,Principal principal) {
		if(generalSpendingDto.getId().equals(id)) {
			generalSpendingDto.setUser(new UserData(principal.getName()));
			return earningRuleService.updateGeneralSpendingEarningRule(generalSpendingDto);
		}
		return null;
	}
	
	
	
	@GetMapping("/admin/earningRule")
	@ResponseBody
	@ResponseStatus(value=HttpStatus.OK)
	public GenericDataTableResponse<EarningRuleDto>  getEarningRule(@RequestParam String companyId) {
		List<EarningRule> earningRules= earningRuleService.getEarningRules(companyId);
	    GenericDataTableResponse<EarningRuleDto> response=new GenericDataTableResponse<EarningRuleDto>();
	    
	    if(earningRules!=null && earningRules.size()>0) {
	    	response.setData(earningRules.stream().map(earningRule_-> new EarningRuleDto(earningRule_)  ).collect(Collectors.toList()));
	    	response.setPage(1);
	    	response.setPageSize(10);
	    	response.setTotalRecords(response.getData().size());
	    	//response.setTotalPages(totalPages);
	    }
	    return response;
	}
}
