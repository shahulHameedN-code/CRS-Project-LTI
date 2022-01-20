package com.lt.APIGateway.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lt.APIGateway.exception.CourseNotFoundException;
import com.lt.APIGateway.exception.StudentReportCardNotFoundException;

@RestController
@RequestMapping("/gateway")
public class RouterController {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/professor/addGrades", method = RequestMethod.POST)
	public String routeToProfessorAddGrade(@RequestBody String professorJson) {
		String url = serviceUrl("PROFESSOR_MODULE") + "/professor/addGrades";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(professorJson, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);

	}

	@RequestMapping(path = "/professor/viewStudents/{courseId}", method = RequestMethod.GET, produces = "application/json")
	public String routeToProfessorviewStudents(@PathVariable("courseId") String courseId) {
		String url = serviceUrl("PROFESSOR_MODULE") + "/professor/viewStudents/" + courseId;
		System.out.println("url " + url);
		return restTemplate.getForObject(url, String.class);

	}

	/**
	 * Method to removeCourse from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @return msg
	 */
	@RequestMapping(path = "/admin/removeCourse/{courseId}", method = RequestMethod.GET)
	public String removeCourse(@PathVariable("courseId") String courseId) throws CourseNotFoundException {

		String url = serviceUrl("ADMIN_MODULE") + "/admin/removeCourse/" + courseId;
		return restTemplate.getForObject(url, String.class);

	}

	/**
	 * This is generateReportCard method
	 * 
	 * @param studentId
	 * @return null
	 * @exception SQLException
	 */
	@RequestMapping(path = "/admin/generateReportCard/{studentId}", method = RequestMethod.GET)
	public String generateReportCard(@PathVariable("studentId") String studentId)
			throws StudentReportCardNotFoundException {
		String url = serviceUrl("ADMIN_MODULE") + "/admin/generateReportCard/" + studentId;
		return restTemplate.getForObject(url, String.class);
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
	@RequestMapping(value = "/admin/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String addCourse(@RequestBody String courseDetail) {
		String url = serviceUrl("ADMIN_MODULE") + "/admin/addCourse/";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(courseDetail, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);

	}

	/**
	 * Method to addprofessor
	 * 
	 * @param professorId
	 * @param professorName
	 * @return professor
	 */

	@RequestMapping(path = "/admin/addProfessor", method = RequestMethod.POST)
	public String addprofessor(@RequestBody String addProfessorJson) {
		String url = serviceUrl("ADMIN_MODULE") + "/admin/addProfessor/";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(addProfessorJson, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);

	}

	/**
	 * Method to approvedStudent
	 * 
	 * @param userId
	 * @return userId
	 */
	@RequestMapping(value = "/admin/approveStudent/{userId}", method = RequestMethod.GET, produces = "application/json")
	public String approvedStudent(@PathVariable String userId) {
		String url = serviceUrl("ADMIN_MODULE") + "/admin/approveStudent/" + userId;
		return restTemplate.getForObject(url, String.class);
	}

	/**
	 * This is registerStudent method
	 * 
	 * @param name
	 * @param id
	 * @param address
	 * @param email
	 * @return student
	 */
	@RequestMapping(value = "/student/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String studentRegistration(@RequestBody String registration) {
		String url = serviceUrl("STUDENT_MODULE") + "/student/registration/";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(registration, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);
	}

	/**
	 * This is addCourse method add the course into list
	 * 
	 * @param studentId
	 * @param courseId
	 * @exception SQLException
	 * @return studentCourseList
	 */
	@RequestMapping(value = "/student/addCourse", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String addCourses(@RequestBody String course) {
		String url = serviceUrl("STUDENT_MODULE") + "/student/addCourse";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(course, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);
	}

	/**
	 * This is removeCourse method remove the course from list
	 * 
	 * @param studentId
	 * @param courseId
	 * @return row
	 */
	@RequestMapping(path = "/student/removeCourse", method = RequestMethod.POST)
	public String studentRemoveCourse(@RequestBody String removeCourseJson) throws CourseNotFoundException {
		String url = serviceUrl("STUDENT_MODULE") + "/student/removeCourse";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(removeCourseJson, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);
	}

	/**
	 * This is viewGrades method
	 * 
	 * @param studentId
	 * @return courseList
	 */
	@RequestMapping(path = "/student/viewGrades/{studentId}", method = RequestMethod.GET, produces = "application/json")
	public String viewGrades(@PathVariable("studentId") String studentId) {
		String url = serviceUrl("STUDENT_MODULE") + "/student/viewGrades/" + studentId;
		return restTemplate.getForObject(url, String.class);
	}

	/**
	 * This is fetchPayment method
	 * 
	 * @param studentId
	 * @return paymentList
	 */
	@RequestMapping(path = "/student/fetchPayment", method = RequestMethod.POST, produces = "application/json")
	public String fetchPayment(@RequestBody String fetchPaymentJson) {
		String url = serviceUrl("STUDENT_MODULE") + "/student/fetchPayment";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(fetchPaymentJson, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);
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
	public String makePaymentNew(@RequestBody String makePaymentJson) {
		String url = serviceUrl("STUDENT_MODULE") + "/student/fetchPayment";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(makePaymentJson, headers);

		System.out.println("url " + url);

		return restTemplate.postForObject(url, entity, String.class);
	}

	public String serviceUrl(String appName) {

		String hostName = discoveryClient.getInstances(appName).get(0).getHost();
		int port = discoveryClient.getInstances(appName).get(0).getPort();

		String url = "http://" + hostName + ":" + port;

		return url;
	}

}
