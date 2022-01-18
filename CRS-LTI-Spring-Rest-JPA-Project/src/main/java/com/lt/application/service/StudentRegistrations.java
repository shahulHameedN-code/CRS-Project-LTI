package com.lt.application.service;

import com.lt.application.entity.Notification;
import com.lt.application.exception.PasswordMismatchException;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital it is the interface of
 *         StudentRegistrations and these methods needs to implement in another
 *         class
 */
public interface StudentRegistrations {
	public Notification studentRegistration(String registration) throws PasswordMismatchException;
}
