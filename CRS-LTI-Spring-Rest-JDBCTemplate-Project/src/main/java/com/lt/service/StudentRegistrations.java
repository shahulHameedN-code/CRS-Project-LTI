package com.lt.service;

import com.lt.exception.PasswordMismatchException;
/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * it is the interface of StudentRegistrations
 * and these methods needs to implement in another class
 */
public interface StudentRegistrations {
	public String studentRegistration(String registration) throws PasswordMismatchException;
}
