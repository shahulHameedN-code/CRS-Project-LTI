package com.lt.service;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import com.lt.intrfc.AddGrades;
import com.lt.repository.StudentRepository;

@Configuration
public class AddGradeImpl implements AddGrades {

	@Override
	public String addgrades(String addGradeJson) {
		JSONObject jso = new JSONObject(addGradeJson);
		String studentId = jso.getString("studentId");
		String courseId = jso.getString("courseId");
		String grade = jso.getString("grade");
		return StudentRepository.addgrades(studentId, courseId, grade);
	}

}
