/**
 * 
 */
package com.lt.student.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.student.beans.Notification;
import com.lt.student.beans.Student;
import com.lt.student.beans.UserLogin;
import com.lt.student.exception.PasswordMismatchException;
import com.lt.student.repository.LoginRepository;
import com.lt.student.repository.StudentRepository;

/**
 * @author Jeaswanth
 *
 *         it is the implementation class of StudentRegistrations interface
 */
@Service
public class StudentRegistrationsImpl implements StudentRegistrations {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	LoginRepository loginRepository;

	/**
	 * Method to studentRegistration
	 * 
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
		Student s = new Student();
		UserLogin userLogin = new UserLogin();

		String pass = jsonObject.getString("password");
		String conPass = jsonObject.getString("confirmPassword");
		if (pass.equals(conPass))
			userLogin.setPassword(pass);
		else
			throw new PasswordMismatchException();

		s.setName(jsonObject.getString("name"));
		s.setStudentId(jsonObject.getString("id"));
		s.setEmailId(jsonObject.getString("emailId"));
		s.setAddress(jsonObject.getString("address"));

		userLogin.setUserName(jsonObject.getString("name"));
		userLogin.setApproved(false);
		userLogin.setUserId(jsonObject.getString("id"));
		studentRepository.save(s);
		loginRepository.save(userLogin);

		return new Notification("Registration Successful for student " + s.getName());

	}

}
