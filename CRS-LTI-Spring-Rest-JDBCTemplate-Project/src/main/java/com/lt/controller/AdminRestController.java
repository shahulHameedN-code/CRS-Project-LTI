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

	@RequestMapping(path = "/removeCourse/{courseId}", method = RequestMethod.POST)
	public ResponseEntity<String> removeCourse(@PathVariable("courseId") String courseId)
			throws CourseNotFoundException {
		String result = adminService.removeCourse(courseId);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/generateReportCard/{studentId}", method = RequestMethod.GET)
	public ResponseEntity<String> generateReportCard(@PathVariable("studentId") String studentId)
			throws StudentReportCardNotFoundException {
		JSONObject result = adminService.generateReportCard(studentId);
		return ResponseEntity.ok(result.toString());
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourse(@RequestBody String courseDetail) {
		String result = adminService.addCourse(courseDetail);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/addProfessor", method = RequestMethod.POST)
	public ResponseEntity<String> addprofessor(@RequestBody String addProfessorJson) {
		String result = adminService.addprofessor(addProfessorJson);
		return ResponseEntity.ok(result);

	}

}
