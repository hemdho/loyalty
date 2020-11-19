package com.hem.exception;

public class RecordNotFoundException extends RuntimeException{

	private String message;
	private Exception exception;
	
	public RecordNotFoundException(String message) {
		this.message=message;
	}
}
