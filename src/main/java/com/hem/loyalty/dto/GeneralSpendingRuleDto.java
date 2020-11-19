package com.hem.loyalty.dto;

import java.util.Set;

import com.hem.loyalty.service.Activity;
import com.hem.loyalty.service.GeneralSpendingEarningRule;
import com.hem.loyalty.service.SKULabel;

public class GeneralSpendingRuleDto extends EarningRuleDto{
	private int pointValue;
	private Set<String> excludedSKU;
	private Set<SKULabel> labelsIncluded;
	private Set<SKULabel> labelExcluded;
	private double minOrderValue;
	private boolean isLastRule;
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
	public String toString() {
		return super.toString()+ " GeneralSpendingRuleDto [pointValue=" + pointValue + ", excludedSKU=" + excludedSKU + ", labelsIncluded="
				+ labelsIncluded + ", labelExcluded=" + labelExcluded + ", minOrderValue=" + minOrderValue
				+ ", isLastRule=" + isLastRule + "]";
	}
	
	public GeneralSpendingEarningRule toGeneralSpendingEarningRule() {
		GeneralSpendingEarningRule rule=new GeneralSpendingEarningRule();
		rule.setDescription(getDescription());
		rule.setExcludedSKU(getExcludedSKU());
		Activity activity=new Activity();
		activity.setAllTime(isAllTime());
		activity.setStartDate(getStartDate());
		activity.setEndDate(getEndDate());
		rule.setActivity(activity);
		rule.setLabelExcluded(getLabelExcluded());
		rule.setLastRule(isLastRule());
		rule.setLevels(getLevels());
		rule.setMinOrderValue(getMinOrderValue());
		rule.setName(getName());
		rule.setPointValue(getPointValue());
		rule.setPriority(getPriority());
		rule.setSegments(getSegments());
		rule.setStatus(isEnabled());
		
		return rule;
	}
	
}
