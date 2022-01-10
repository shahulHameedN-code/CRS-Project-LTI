package com.lt.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Student;
import com.lt.exception.AddGradeException;
import com.lt.repository.ProfessorRepository;
/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * 
 * it is the implementation class of professor interface
 */

@Service
public class ProfessorServiceImpl {

	@Autowired
	ProfessorRepository professorRepo;

	public List<Student> viewEnrolledStudents(String courseId) {
		return professorRepo.viewEnrolledStudents(courseId);
	}

	public String addgrades(String addGradeJson) throws AddGradeException {
		JSONObject jso = new JSONObject(addGradeJson);
		String studentId = jso.getString("studentId");
		String courseId = jso.getString("courseId");
		String grade = jso.getString("grade");
		int row= professorRepo.addgrades(studentId, courseId, grade);
		
		if(row==0)
			throw new AddGradeException();
		
		return "Grade was assigned for the student successfully!";
	}

}
