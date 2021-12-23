package com.lt.crs.exception;

public class SaveCourseException extends Exception {

	private String message;

	public SaveCourseException(String message) {
		super(message);
		this.message = message;
	}

	public SaveCourseException() {

	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}

}
