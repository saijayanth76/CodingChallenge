package com.hexaware.exception;

public class OrderNotFoundException extends Exception {

	String message;

	public OrderNotFoundException(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
