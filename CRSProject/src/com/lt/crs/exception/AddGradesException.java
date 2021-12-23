package com.lt.crs.exception;

/**
 * The class Add grades exception extends exception
 */
public class AddGradesException extends Exception {

	private String message;

	/**
	 * Parameterized Constructor Add grades exception
	 *
	 * @param message the message
	 * @return
	 */
	public AddGradesException(String message) {

		super(message);
		this.message = message;
	}

	/**
	 *
	 * Add grades exception Default constructor
	 * 
	 * @return public
	 */
	public AddGradesException() {

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
