package com.lt.student.service;

import javax.management.Notification;

import com.lt.student.exception.PasswordMismatchException;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital it is the interface of
 *         StudentRegistrations and these methods needs to implement in another
 *         class
 */
public interface StudentRegistrations {
	public com.lt.student.beans.Notification studentRegistration(String registration) throws PasswordMismatchException;
}
