package com.lt.crs.exception;

public class PaymentException extends Exception {

	private String message;

	public PaymentException() {
		// TODO Auto-generated constructor stub
	}

	public PaymentException(String message) {
		super(message);
		this.message = message;

	}

}
