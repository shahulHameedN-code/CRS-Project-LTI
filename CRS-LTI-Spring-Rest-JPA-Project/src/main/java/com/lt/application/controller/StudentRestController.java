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

import com.lt.application.entity.Notification;
import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.exception.PasswordMismatchException;
import com.lt.application.exception.PaymentFaildException;
import com.lt.application.exception.PaymentNotFoundException;
import com.lt.application.exception.ViewGradeException;
import com.lt.application.repository.PaymentRepository.PaymentResponse;
import com.lt.application.repository.StudentCourseRepository.ViewGrades;
import com.lt.application.service.MakePaymentImpl;
import com.lt.application.service.StudentRegistrations;
import com.lt.application.service.StudentServiceImpl;

/**
 * @author Jeaswanth,Shital,shahul,shraddha,sayli,parag.
 * it is the RestController class of StudentRestController it is the used to create RESTful web services
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentRestController {

	private static Logger log = LoggerFactory.getLogger(StudentRestController.class);

	@Autowired
	StudentRegistrations registrations;

	@Autowired
	StudentServiceImpl studentServiceImpl;

	@Autowired
	MakePaymentImpl makePaymentImpl;

	/**
	 * This is registerStudent method
	 * 
	 * @param name
	 * @param id
	 * @param address
	 * @param email
	 * @return student
	 */
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Notification> studentRegistration(@RequestBody String registration)
			throws PasswordMismatchException {
		log.info("Entering Student Registartion Controller");

		Notification n = registrations.studentRegistration(registration);

		log.info("returning from Student Registartion Controller");
		return ResponseEntity.ok(n);
	}

	/**
	 * This is addCourse method add the course into list
	 * 
	 * @param studentId
	 * @param courseId
	 * @exception SQLException
	 * @return studentCourseList
	 */
	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> addCourses(@RequestBody String course) {
		log.info("Entering add course Controller");
		String result = studentServiceImpl.addCourses(course);
		log.info("returning from add course Controller");
		return ResponseEntity.ok(result);
	}

	/**
	 * This is removeCourse method remove the course from list
	 * 
	 * @param studentId
	 * @param courseId
	 * @return row
	 */
	@RequestMapping(path = "/removeCourse", method = RequestMethod.POST)
	public ResponseEntity<String> removeCourse(@RequestBody String removeCourseJson) throws CourseNotFoundException {
        log.info("Enterning removeCourse controller");
		String result = studentServiceImpl.removeCourse(removeCourseJson);
		log.info("returning from removeCourse controller");
		return ResponseEntity.ok(result);
	}

	/**
	 * This is viewGrades method
	 * 
	 * @param studentId
	 * @return courseList
	 */
	@RequestMapping(path = "/viewGrades/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<ViewGrades>> viewGrades(@PathVariable("studentId") String studentId)
			
			throws ViewGradeException {
		log.info("Enterning viewGrades controller");
		List<ViewGrades> courseList = studentServiceImpl.viewGrades(studentId);
		log.info(" returning from ListCourse controller");
		return ResponseEntity.ok(courseList);
	}

	/**
	 * This is fetchPayment method
	 * 
	 * @param studentId
	 * @return paymentList
	 */
	@RequestMapping(path = "/fetchPayment", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<List<PaymentResponse>> fetchPayment(@RequestBody String fetchPaymentJson)
			throws PaymentNotFoundException {
		log.info("Enterning fetchpayment controller");
		List<PaymentResponse> payment = studentServiceImpl.fetchPayment(fetchPaymentJson);
		log.info("Returning fetchpayment controller");
		return ResponseEntity.ok().body(payment);
	}

	/**
	 * This is makePayment method
	 * 
	 * @param studentId
	 * @return paymentId
	 * @param PaymentFee
	 * @return row
	 */
	@RequestMapping(path = "/makePayment", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<Notification> makePaymentNew(@RequestBody String makePaymentJson)
			throws PaymentFaildException {
		log.info("Enterning makePayment controller");
		
		log.info("Returning from makePayment controller");
		return ResponseEntity.ok(studentServiceImpl.makePayment(makePaymentJson));
	}

}
