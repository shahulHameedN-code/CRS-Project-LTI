/**
 * 
 */
package com.lt.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Notification;
import com.lt.bean.StudentRegistration;
import com.lt.exception.PasswordMismatchException;
import com.lt.repository.StudentRepository;

/**
 * @author Jeaswanth
 *
 *         it is the implementation class of StudentRegistrations interface
 */
@Service
public class StudentRegistrationsImpl implements StudentRegistrations {

	@Autowired
	StudentRepository studentRepo;
	/**
	 * Method to studentRegistration 
	 * @param Id
	 * @param address
	 * @param emailId
	 * @param password
	 * @param confirmPassword
	 * @throws PasswordMismatchException 
	 * @return student
	 */
	@Override
	public Notification studentRegistration(String registration) throws PasswordMismatchException {
		JSONObject jsonObject = new JSONObject(registration);

		StudentRegistration student = new StudentRegistration();
		student.setId(jsonObject.getString("id"));
		student.setAddress(jsonObject.getString("address"));
		student.setEmail(jsonObject.getString("emailId"));
		String pass = jsonObject.getString("password");
		String conPass = jsonObject.getString("confirmPassword");
		if (pass.equals(conPass))
			student.setPassword(pass);
		else
			throw new PasswordMismatchException();

		student.setName(jsonObject.getString("name"));

		String message = studentRepo.registerStudent(student);
		return new Notification(message);

	}

}
