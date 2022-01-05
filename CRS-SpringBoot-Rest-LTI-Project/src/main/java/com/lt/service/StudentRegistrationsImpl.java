/**
 * 
 */
package com.lt.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lt.bean.StudentRegistration;
import com.lt.intrfc.StudentRegistrations;

/**
 * @author Jeaswanth
 *
 */
@Service
public class StudentRegistrationsImpl implements StudentRegistrations {

	private static List<StudentRegistration> students = new ArrayList<StudentRegistration>();

	@Override
	public String studentRegistration(String registration) {
		JSONObject jsonObject = new JSONObject(registration);
		StudentRegistration student = new StudentRegistration();
		student.setId(jsonObject.getInt("id"));
		student.setDob(jsonObject.getString("DOB"));
		student.setEmail(jsonObject.getString("email"));
		student.setName(jsonObject.getString("name"));
		student.setUserName(jsonObject.getString("userName"));
		student.setPassword(jsonObject.getString("password"));

		students.add(student);
		return "Student " + student.getName() + " registered successfully";
	}

}
