/**
 * 
 */
package com.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;
import com.lt.exception.AddGradeException;
import com.lt.exception.CourseNotFoundException;
import com.lt.service.ProfessorServiceImpl;

/**
 * @author shraddha it is the RestController class of professor it is the used
 *         to create RESTful web services
 */

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfesorRestController {

	@GetMapping("/welcome")
	public String getHomePage() {

		return "Hello Professor";
	}

	@Autowired
	ProfessorServiceImpl professorService;

	/**
	 * This is viewEnrolledStudents method
	 * 
	 * @param courseId
	 * @return studentList
	 */
	@RequestMapping(path = "/viewStudents/{courseId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> viewStudents(@PathVariable("courseId") String courseId)
			throws CourseNotFoundException {

		List<Student> student = professorService.viewEnrolledStudents(courseId);

		if (student == null)
			throw new CourseNotFoundException();

		return ResponseEntity.ok().body(student);
	}

	/**
	 * This is add grades method
	 * 
	 * @param courseId
	 * @param studentId
	 * @param grade
	 * @return row
	 */
	@RequestMapping(path = "/addGrades", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addGrades(@RequestBody String addGradeJson) throws AddGradeException {
		System.out.println("addGradJson " + addGradeJson);
		return ResponseEntity.ok(professorService.addgrades(addGradeJson));

	}

}
