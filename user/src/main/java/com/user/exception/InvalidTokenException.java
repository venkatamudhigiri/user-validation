package com.user.exception;

public class InvalidTokenException extends RuntimeException{

	
	private static final long serialVersionUID = 1123391797475106965L;

	public InvalidTokenException(String errrorMessage) {
	super(errrorMessage);
	}
}
