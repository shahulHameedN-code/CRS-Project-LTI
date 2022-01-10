/**
 * 
 */
package com.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.intrfc.AddCourses;
import com.lt.intrfc.StudentRegistrations;
import com.lt.service.StudentServiceImpl;

/**
 * @author Jeaswanth
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	StudentRegistrations registrations;

	@Autowired
	AddCourses courses;

	@Autowired
	StudentServiceImpl ssi;

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> studentRegistration(@RequestBody String registration) {
		String result = registrations.studentRegistration(registration);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/addCourses", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourses(@RequestBody String course) {
		String result = courses.addCourses(course);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/removeCourse", method = RequestMethod.POST)
	public ResponseEntity<String> removeCourse(@RequestBody String removeCourseJson) {

		String result = ssi.removeCourse(removeCourseJson);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/viewGrades/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<String>> viewGrades(@PathVariable("studentId") String studentId) {

		List<String> grades = ssi.viewGrades(studentId);
		if (grades == null) {
			return new ResponseEntity("No Grades were found for ID " + studentId, HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok().body(grades);
	}

}
