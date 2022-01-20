package com.lt.APIGateway.exception;

public class CourseNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CourseNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public CourseNotFoundException(String message) {
		super(message);
	}

}
