/**
 * 
 */
package com.lt.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Payment;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.PasswordMismatchException;
import com.lt.exception.PaymentFaildException;
import com.lt.exception.PaymentNotFoundException;
import com.lt.exception.ViewGradeException;
import com.lt.intrfc.StudentRegistrations;
import com.lt.service.MakePaymentImpl;
import com.lt.service.StudentServiceImpl;

/**
 * @author Jeaswanth it is the RestController class of StudentRestController it
 *         is the used to create RESTful web services
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	StudentRegistrations registrations;

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@Autowired
	MakePaymentImpl makePaymentImpl;

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> studentRegistration(@RequestBody String registration)
			throws PasswordMismatchException {
		String result = registrations.studentRegistration(registration);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourses(@RequestBody String course) {
		String result = studentServiceImpl.addCourses(course);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/removeCourse", method = RequestMethod.POST)
	public ResponseEntity<String> removeCourse(@RequestBody String removeCourseJson) throws CourseNotFoundException {

		String result = studentServiceImpl.removeCourse(removeCourseJson);
		return ResponseEntity.ok(result);
	}

	@RequestMapping(path = "/viewGrades/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> viewGrades(@PathVariable("studentId") String studentId) throws ViewGradeException {
		List<JSONObject> courseList = studentServiceImpl.viewGrades(studentId);
		return ResponseEntity.ok(courseList.toString());
	}

	@RequestMapping(path = "/fetchPayment", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<Payment>> fetchPayment(@RequestBody String fetchPaymentJson) throws PaymentNotFoundException{
		List<Payment> payment = studentServiceImpl.fetchPayment(fetchPaymentJson);

		return ResponseEntity.ok().body(payment);
	}

	@RequestMapping(path = "/makePayment", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> makePaymentNew(@RequestBody String makePaymentJson) throws PaymentFaildException {
		return ResponseEntity.ok(studentServiceImpl.makePayment(makePaymentJson));
	}

}
