package com.hem.exception;

public class RecordAlreadyExistException extends RuntimeException{

	private String message;
	private Exception exception;
	
	public RecordAlreadyExistException(String message) {
		this.message=message;
	}
}
