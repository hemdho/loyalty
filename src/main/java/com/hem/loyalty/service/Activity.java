package com.hem.loyalty.service;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hem.common.util.CustomDateDeserializer;
import com.hem.common.util.CustomDateSerializer;

public class Activity {
	private boolean allTime;
	 @JsonDeserialize(using = CustomDateDeserializer.class)
	    @JsonSerialize(using=CustomDateSerializer.class)
	    private Date startDate;

	    @JsonDeserialize(using = CustomDateDeserializer.class)
	    @JsonSerialize(using=CustomDateSerializer.class)
	    
		private Date endDate;


	public boolean isAllTime() {
		return allTime;
	}

	public void setAllTime(boolean allTime) {
		this.allTime = allTime;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
