package com.user.exception;

public class UserDetailsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1123391797475106965L;

	String errorCode;
	String errorMessage;

	public UserDetailsNotFoundException(String errrorMessage) {
		super(errrorMessage);
	}

	public UserDetailsNotFoundException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}
