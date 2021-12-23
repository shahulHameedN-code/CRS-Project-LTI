package com.lt.crs.exception;

/**
 * The class Enrolled students exception extends exception
 */
public class EnrolledStudentsException extends Exception {

	private String message;

	/**
	 * parameterized constructor Enrolled students exception
	 *
	 * @param :message the message
	 * @return
	 */
	public EnrolledStudentsException(String message) {

		super(message);
		this.message = message;
	}

	/**
	 *
	 * Enrolled students exception defaultconstructor
	 * 
	 * @return
	 */
	public EnrolledStudentsException() {

	}

	@Override

	/**
	 *
	 * Gets the message
	 *
	 * @return the message
	 */
	public String getMessage() {

		return super.getMessage();
	}

}
