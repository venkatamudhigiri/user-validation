package com.user.exception;

public class InvalidCredentialsException extends RuntimeException{

	
	private static final long serialVersionUID = 1123391797475106965L;

	public InvalidCredentialsException(String errrorMessage) {
	super(errrorMessage);
	}
}
