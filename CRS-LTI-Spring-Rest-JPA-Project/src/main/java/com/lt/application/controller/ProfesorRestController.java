/**
 * 
 */
package com.lt.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.application.exception.AddGradeException;
import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.repository.ProfessorRepository.ViewEnrolledStudentsResponse;
import com.lt.application.service.ProfessorServiceImpl;
/**
 * @author Jeaswanth,Shital,shahul,shraddha,sayli,parag.
 * it is the RestController class of ProfesorRestController it is the used to create RESTful web services
 */
@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfesorRestController {
	private static Logger log = LoggerFactory.getLogger(ProfesorRestController.class);

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
	public ResponseEntity<List<ViewEnrolledStudentsResponse>> viewStudents(@PathVariable("courseId") String courseId)
			throws CourseNotFoundException {
		log.info("Entering viewStudents Controller");

		List<ViewEnrolledStudentsResponse> student = professorService.viewEnrolledStudents(courseId);

		if (student == null)
			throw new CourseNotFoundException();
		log.info("Returning viewStudents Controller");

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
		log.info("Entering addGrades Controller");

		System.out.println("addGradJson " + addGradeJson);
		log.info("Returning addGrades Controller");
		return ResponseEntity.ok(professorService.addgrades(addGradeJson).toString());

	}

}
