package com.lt.crs.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * The class Invalidcredentailsexception extends exception
 */
public class InvalidCredentailsException extends Exception {

	private String message;

	/**
	 *
	 * Invalid credentails exception
	 *
	 * @param message the message
	 * @return
	 */
	public InvalidCredentailsException(String message) {

		super(message);
		this.message = message;
	}

	/**
	 *
	 * Invalid credentails exception
	 *
	 * @return
	 */
	public InvalidCredentailsException() {

	}

	@Override

	/**
	 *
	 * Gets the message
	 *
	 * @return the message
	 */
	public String getMessage() {

		// TODO Auto-generated method stub
		return super.getMessage();
	}

	@Override

	/**
	 *
	 * Gets the localized message
	 *
	 * @return the localized message
	 */
	public String getLocalizedMessage() {

		// TODO Auto-generated method stub
		return super.getLocalizedMessage();
	}

	@Override

	/**
	 *
	 * Gets the cause
	 *
	 * @return the cause
	 */
	public synchronized Throwable getCause() {

		// TODO Auto-generated method stub
		return super.getCause();
	}

	@Override

	/**
	 *
	 * Init cause
	 *
	 * @param cause the cause
	 * @return Throwable
	 */
	public synchronized Throwable initCause(Throwable cause) {

		// TODO Auto-generated method stub
		return super.initCause(cause);
	}

	@Override

	/**
	 *
	 * To string
	 *
	 * @return String
	 */
	public String toString() {

		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override

	/**
	 *
	 * Print stack trace
	 *
	 */
	public void printStackTrace() {

		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	@Override

	/**
	 *
	 * Print stack trace
	 *
	 * @param s the s
	 */
	public void printStackTrace(PrintStream s) {

		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override

	/**
	 *
	 * Print stack trace
	 *
	 * @param s the s
	 */
	public void printStackTrace(PrintWriter s) {

		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override

	/**
	 *
	 * Fill in stack trace
	 *
	 * @return Throwable
	 */
	public synchronized Throwable fillInStackTrace() {

		// TODO Auto-generated method stub
		return super.fillInStackTrace();
	}

	@Override

	/**
	 *
	 * Gets the stack trace
	 *
	 * @return the stack trace
	 */
	public StackTraceElement[] getStackTrace() {

		// TODO Auto-generated method stub
		return super.getStackTrace();
	}

	@Override

	/**
	 *
	 * Sets the stack trace
	 *
	 * @param stackTrace the stack trace
	 */
	public void setStackTrace(StackTraceElement[] stackTrace) {

		// TODO Auto-generated method stub
		super.setStackTrace(stackTrace);
	}

}
