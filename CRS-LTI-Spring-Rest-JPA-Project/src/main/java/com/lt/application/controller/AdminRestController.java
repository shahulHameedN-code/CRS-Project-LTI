/**
 * 
 */
package com.lt.application.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.exception.StudentReportCardNotFoundException;
import com.lt.application.repository.StudentCourseRepository.GenerateReportCard;
import com.lt.application.service.AdminServiceImpl;

/**
 * @author Jeaswanth,shital,shraddha,shahul,sayli,parag.
 * it is the RestController class of AdminRestController it is the used to create RESTful web services
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminRestController {
	private static Logger log = LoggerFactory.getLogger(AdminRestController.class);

	@Autowired
	AdminServiceImpl adminService;

	/**
	 * Method to removeCourse from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @return msg
	 */
	@RequestMapping(path = "/removeCourse/{courseId}", method = RequestMethod.POST)
	public ResponseEntity<String> removeCourse(@PathVariable("courseId") String courseId)
			throws CourseNotFoundException {
		log.info("Enterning removeCourse controller");
		String result = adminService.removeCourse(courseId);
		log.info("Returning from removeCourse controller");
		return ResponseEntity.ok(result);
	}

	/**
	 * This is generateReportCard method
	 * 
	 * @param studentId
	 * @return null
	 * @exception SQLException
	 */
	@RequestMapping(path = "/generateReportCard/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<List<GenerateReportCard>> generateReportCard(@PathVariable("studentId") String studentId)
			throws StudentReportCardNotFoundException {
		log.info("Enterning generateReportCard controller");
		List<GenerateReportCard> result = adminService.generateReportCard(studentId);
		log.info("Returning from generateReportCard controller");
		return ResponseEntity.ok().body(result);
	}

	/**
	 * Method to addCourse from Course Catalog
	 * 
	 * @param courseId
	 * @param name
	 * @param noOfStudents
	 * @param paymentFee
	 * @return courses
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourse(@RequestBody String courseDetail) {
		log.info("Entering add course Controller");
		String result = adminService.addCourse(courseDetail);
		log.info("returning from add course Controller");
		return ResponseEntity.ok(result);
	}

	/**
	 * Method to addprofessor
	 * 
	 * @param professorId
	 * @param professorName
	 * @return professor
	 */

	@RequestMapping(path = "/addProfessor", method = RequestMethod.POST)
	public ResponseEntity<String> addprofessor(@RequestBody String addProfessorJson) {
		log.info("Entering addProfessor Controller");
		String result = adminService.addprofessor(addProfessorJson);
		log.info("returning from addProfessor Controller");
		return ResponseEntity.ok(result);

	}

	/**
	 * Method to approvedStudent
	 * 
	 * @param userId
	 * @return userId
	 */
	@RequestMapping(value = "/approveStudent/{userId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> approvedStudent(@PathVariable String userId) {
		log.info("Entering approveStudent Controller");
		String result = adminService.approvedStudent(userId);
		log.info("returning from approveStudent Controller");
		return ResponseEntity.ok(result);
	}
}
