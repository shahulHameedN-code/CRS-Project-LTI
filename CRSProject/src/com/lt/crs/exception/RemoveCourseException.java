package com.lt.crs.exception;

public class RemoveCourseException extends Exception {

	private String message;

	public RemoveCourseException(String message) {
		super(message);
		this.message = message;
	}

	public RemoveCourseException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
