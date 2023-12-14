package com.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserDetailsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserDetailsNotFoundException(UserDetailsNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(1001, ex.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
	}

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCredentialsException(InvalidCredentialsException ex) {
		ErrorResponse errorResponse = new ErrorResponse(1002, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	@ExceptionHandler(TransactionsNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleTransactionsNotFoundException(TransactionsNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(2002, ex.getMessage());
		return ResponseEntity.status(HttpStatus.OK).body(errorResponse);
	}

	@ExceptionHandler(InvalidTokenException.class)
	public ResponseEntity<ErrorResponse> handleInvalidTokenException(InvalidTokenException ex) {
		ErrorResponse errorResponse = new ErrorResponse(2003, ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

	public static class ErrorResponse {
		private int errorCode;
		private String errorMessage;

		public ErrorResponse(int errorCode, String errorMessage) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
		}

		// Getters and setters (or use Lombok for simplicity)
		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}
	}
}
