/**
 * 
 */
package com.lt.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.exception.CourseNotFoundException;
import com.lt.exception.StudentReportCardNotFoundException;
import com.lt.service.AdminServiceImpl;

/**
 * @author Jeaswanth
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminRestController {

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
		String result = adminService.removeCourse(courseId);
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
	public ResponseEntity<String> generateReportCard(@PathVariable("studentId") String studentId)
			throws StudentReportCardNotFoundException {
		JSONObject result = adminService.generateReportCard(studentId);
		return ResponseEntity.ok(result.toString());
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
		String result = adminService.addCourse(courseDetail);
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
		String result = adminService.addprofessor(addProfessorJson);
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
		String result = adminService.approvedStudent(userId);
		return ResponseEntity.ok(result);
	}
}
