/**
 * 
 */
package com.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Student;
import com.lt.repository.CourseRepository;
import com.lt.service.AddGradeImpl;

/**
 * @author shraddha
 *
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
	private CourseRepository courseRepo;

	@Autowired
	private AddGradeImpl addGradeImpl;

	@RequestMapping(path = "/viewStudents/{courseId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Student>> viewStudents(@PathVariable("courseId") String courseId) {

		List<Student> student = courseRepo.viewEnrolledStudents(courseId);
		if (student == null) {
			return new ResponseEntity("No Course found for ID " + courseId, HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok().body(student);
	}

	@RequestMapping(path = "/addGrades", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> addGrades(@RequestBody String addGradeJson) {
		return ResponseEntity.ok(addGradeImpl.addgrades(addGradeJson));

	}

}
