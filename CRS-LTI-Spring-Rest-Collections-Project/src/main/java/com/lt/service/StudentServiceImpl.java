package com.lt.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.intrfc.StudentService;
import com.lt.repository.StudentRepository;

/**
 * @author Shahul
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository sr;

	@Override
	public String removeCourse(String removeCourseJson) {
		JSONObject jso = new JSONObject(removeCourseJson);
		String studentId = jso.getString("studentId");
		String courseId = jso.getString("courseId");

		return sr.removeCourse(studentId, courseId);

	}

	public List<String> viewGrades(String studentId) {
		// TODO Auto-generated method stub
		return sr.viewGrades(studentId);

	}

}
