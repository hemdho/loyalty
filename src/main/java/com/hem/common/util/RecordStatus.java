package com.hem.common.util;

public enum RecordStatus {
    ACTIVE(true),INACTIVE(false);
    private boolean status;
	RecordStatus(boolean b) {
		// TODO Auto-generated constructor stub
		status=b;
	}
	boolean getStatus() {
		return status;
	}
	
	
	
}
