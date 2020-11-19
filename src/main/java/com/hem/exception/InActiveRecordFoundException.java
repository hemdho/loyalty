package com.hem.exception;

public class InActiveRecordFoundException extends RuntimeException{

	private String message;
	private Exception exception;
	
	public InActiveRecordFoundException(String message) {
		this.message=message;
	}
}
