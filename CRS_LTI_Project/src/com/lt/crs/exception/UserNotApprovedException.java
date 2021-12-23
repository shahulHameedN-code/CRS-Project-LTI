package com.lt.crs.exception;

public class UserNotApprovedException extends Exception {

	private String message;

	public UserNotApprovedException(String message) {
		super(message);
		this.message = message;
	}

	public UserNotApprovedException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
