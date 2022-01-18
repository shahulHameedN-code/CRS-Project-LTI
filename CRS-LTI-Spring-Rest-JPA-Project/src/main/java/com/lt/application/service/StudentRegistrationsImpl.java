/**
 * 
 */
package com.lt.application.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.application.entity.Notification;
import com.lt.application.entity.Student;
import com.lt.application.entity.UserLogin;
import com.lt.application.exception.PasswordMismatchException;
import com.lt.application.repository.LoginRepository;
import com.lt.application.repository.StudentRepository;

/**
 * @author Jeaswanth
 *
 *         it is the implementation class of StudentRegistrations interface
 */
@Service
public class StudentRegistrationsImpl implements StudentRegistrations {

	private static Logger log = LoggerFactory.getLogger(StudentRegistrationsImpl.class);

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

		log.info("Entering student details for registration from student registration service");
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

		log.info("Returning student registration from student registration service");
		return new Notification("Registration Successful for student " + s.getName());

	}

}
