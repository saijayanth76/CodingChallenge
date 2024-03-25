package com.hexaware.exception;

public class UserNotFoundException extends Exception {

	String message;

	public UserNotFoundException(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
