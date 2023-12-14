package com.user.exception;

public class TransactionsNotFoundException extends RuntimeException{

	
	private static final long serialVersionUID = 1123391797475106965L;

	public TransactionsNotFoundException(String errrorMessage) {
	super(errrorMessage);
	}
}
