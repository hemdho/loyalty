package com.hem.loyalty.service;

import java.util.Date;

public class Activity {
	private boolean allTime;
	private Date startDate;
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
