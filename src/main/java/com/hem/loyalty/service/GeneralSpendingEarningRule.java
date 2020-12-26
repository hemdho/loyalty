package com.hem.loyalty.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.hem.loyalty.model.SKULabel;
import com.hem.loyalty.repository.CustomerRepository;

@Document (value="EarningRule")
public class GeneralSpendingEarningRule extends EarningRule {

	@Id
	private String id;
	private int pointValue;
    private int pointValuePerCurrency;
    
	private List<SKULabel> excludedSKU;

	private List<SKULabel> labelsIncluded;
	private List<SKULabel> labelExcluded;
	private double minOrderValue;
	
	private boolean isLastRule;

	@Autowired
	CustomerRepository customerRepo;

	public GeneralSpendingEarningRule() {
		setType("General Spending");
	}

	
	public int getPointValue() {
		return pointValue;
	}

	public void setPointValue(int pointValue) {
		this.pointValue = pointValue;
	}

	public List<SKULabel> getExcludedSKU() {
		return excludedSKU;
	}

	public void setExcludedSKU(List<SKULabel> excludedSKU) {
		this.excludedSKU = excludedSKU;
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
	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;

	}

	public int getPointValuePerCurrency() {
		return pointValuePerCurrency;
	}

	public void setPointValuePerCurrency(int pointValuePerCurrency) {
		this.pointValuePerCurrency = pointValuePerCurrency;
	}

}
