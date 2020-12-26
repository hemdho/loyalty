package com.hem.loyalty.dto;

import java.util.List;

import com.hem.loyalty.model.Company;
import com.hem.loyalty.model.SKULabel;
import com.hem.loyalty.service.Activity;
import com.hem.loyalty.service.GeneralSpendingEarningRule;

public class GeneralSpendingRuleDto extends EarningRuleDto{
	private int pointValue;
	
	private int pointValuePerCurrency;
	private List<SKULabel> labelsIncluded;
	private List<SKULabel> labelExcluded;
	private double minOrderValue;
	private boolean isLastRule;
	
	private List<SKULabel> excludedSKUs;
	public int getPointValue() {
		return pointValue;
	}
	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}
	
	public List<SKULabel> getLabelsIncluded() {
		return labelsIncluded;
	}
	public void setLabelsIncluded(List<SKULabel> labelsIncluded) {
		this.labelsIncluded = labelsIncluded;
	}
	public List<SKULabel> getLabelExcluded() {
		return labelExcluded;
	}
	public void setLabelExcluded(List<SKULabel> labelExcluded) {
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
	public String toString() {
		return super.toString()+ " GeneralSpendingRuleDto [pointValue=" + pointValue + ", excludedSKU=" + excludedSKUs + ", labelsIncluded="
				+ labelsIncluded + ", labelExcluded=" + labelExcluded + ", minOrderValue=" + minOrderValue
				+ ", isLastRule=" + isLastRule + "]";
	}
	
	public List<SKULabel> getExcludedSKUs() {
		return excludedSKUs;
	}
	public void setExcludedSKUs(List<SKULabel> excludedSKUs) {
		this.excludedSKUs = excludedSKUs;
	}
	public GeneralSpendingRuleDto() {
		
	}
	
	public GeneralSpendingRuleDto(GeneralSpendingEarningRule earningRule) {
		super(earningRule);
		setExcludedSKUs(earningRule.getExcludedSKU());
		setLabelExcluded(earningRule.getLabelExcluded());
		setLabelsIncluded(earningRule.getLabelsIncluded());
		setMinOrderValue(earningRule.getMinOrderValue());
		setPointValue(earningRule.getPointValue());
		setPointValuePerCurrency(earningRule.getPointValuePerCurrency());
		setLastRule(earningRule.isLastRule());
	}
	public void toGeneralSpendingEarningRule(GeneralSpendingEarningRule rule) {
		super.toEarningRule(rule);
		rule.setExcludedSKU(getExcludedSKUs());
		rule.setLabelExcluded(getLabelExcluded());
		rule.setLastRule(isLastRule());
		rule.setMinOrderValue(getMinOrderValue());
		rule.setPointValue(getPointValue());
		rule.setPointValue(getPointValue());
		rule.setPointValuePerCurrency(getPointValuePerCurrency());	
	}
	public GeneralSpendingEarningRule toGeneralSpendingEarningRule() {
		GeneralSpendingEarningRule rule=new GeneralSpendingEarningRule();
		toGeneralSpendingEarningRule(rule);
		return rule;
	}
	public int getPointValuePerCurrency() {
		return pointValuePerCurrency;
	}
	public void setPointValuePerCurrency(int pointValuePerCurrency) {
		this.pointValuePerCurrency = pointValuePerCurrency;
	}
	
}
