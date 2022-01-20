package com.lt.professor.service;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.professor.exception.AddGradeException;
import com.lt.professor.exception.CourseNotFoundException;
import com.lt.professor.repository.ProfessorRepository;
import com.lt.professor.repository.ProfessorRepository.ViewEnrolledStudentsResponse;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * 
 *         it is the implementation class of professor interface
 */

@Service
public class ProfessorServiceImpl {

	private static Logger log = LoggerFactory.getLogger(ProfessorServiceImpl.class);

	@Autowired
	ProfessorRepository professorRepo;

	/**
	 * it is List<Student> viewEnrolledStudents
	 * 
	 * @param courseId
	 * @return courseId
	 */
	public List<ViewEnrolledStudentsResponse> viewEnrolledStudents(String courseId) throws CourseNotFoundException {

		log.info("Entering courseId for view enrolled students from professor service");
		List<ViewEnrolledStudentsResponse> enrolledStudents = professorRepo.viewEnrolledStudents(courseId);
		if (enrolledStudents == null)
			throw new CourseNotFoundException();
		log.info("Returning view enrolled students from professor service");
		return enrolledStudents;
	}

	/**
	 * Method to addgrades from Course Catalog
	 * 
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @throws AddGradeException
	 * @return massage
	 */
	public JSONObject addgrades(String addGradeJson) throws AddGradeException {

		log.info("Entering grades from professor service");
		JSONObject jso = new JSONObject(addGradeJson);
		String studentId = jso.getString("studentId");
		String courseId = jso.getString("courseId");
		String grade = jso.getString("grade");
		int row = professorRepo.addgrades(grade, studentId, courseId);

		if (row == 0)
			throw new AddGradeException();
		log.info("Returning grades added from professor service");
		return new JSONObject().put("message", "Grade added succesfully");

	}
}
