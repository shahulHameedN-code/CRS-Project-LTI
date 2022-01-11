package com.lt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.Notification;
import com.lt.bean.Payment;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.PaymentFaildException;
import com.lt.exception.PaymentNotFoundException;
import com.lt.exception.ViewGradeException;
import com.lt.repository.StudentRepository;

/**
 * @author Shahul
 * 
 *         This is implementetion class of StudentService
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	/**
	 * Method to removeCourse
	 * 
	 * @param studentId
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @return massage
	 */
	@Override
	public String removeCourse(String removeCourseJson) throws CourseNotFoundException {
		JSONObject jso = new JSONObject(removeCourseJson);
		String studentId = jso.getString("studentId");
		String courseId = jso.getString("courseId");

		int row = studentRepo.removeCourse(studentId, courseId);
		if (row == 0)
			throw new CourseNotFoundException();
		return "course removed succesfully";

	}

	/**
	 * Method to viewGrades
	 * 
	 * @param studentId
	 * @throws ViewGradeException
	 * @return jsonObj
	 */
	public List<JSONObject> viewGrades(String studentId) throws ViewGradeException {
		List<Course> courseList = studentRepo.viewGrades(studentId);
		if (courseList.size() == 0)
			throw new ViewGradeException();

		List<JSONObject> jsonObj = new ArrayList<>();
		for (Course course : courseList) {
			JSONObject obj = new JSONObject();
			obj.put("courseId", course.getId());
			obj.put("courseName", course.getName());
			obj.put("grade", course.getGrade());
			jsonObj.add(obj);
		}
		return jsonObj;

	}

	/**
	 * Method to addCourses
	 * 
	 * @param studentId
	 * @param courseId
	 * @return studentCourseList
	 */
	public String addCourses(String course) {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject(course);

		JSONArray jsa = jsonObj.getJSONArray("courseList");
		ArrayList<JSONObject> studentCourseList = new ArrayList<>();
		for (int i = 0; i < jsa.length(); i++) {
			JSONObject jso = new JSONObject();
			jso.put("studentId", jsonObj.getString("studentId"));
			jso.put("courseId", jsa.getJSONObject(i).getString("courseId"));
			studentCourseList.add(jso);

		}
		return studentRepo.addCourse(studentCourseList);

	}

	/**
	 * Method to makePayment
	 * 
	 * @param studentId
	 * @param cardNumber
	 * @param paymentFee
	 * @param cvvNumber
	 * @param pin
	 * @return payment
	 */
	public Notification makePayment(String makePaymentJson) throws PaymentFaildException {
		Random r = new Random();
		JSONObject jso = new JSONObject(makePaymentJson);
		Payment payment = new Payment();

		payment.setStudentId(jso.getString("studentId"));
		payment.setPaymentFee(jso.getInt("paymentFee"));
		payment.setCardNumber(jso.getInt("cardNumber"));
		payment.setCvvNumber(jso.getInt("cvvNumber"));
		payment.setPin(jso.getInt("pin"));
		payment.setPaymentId(r.nextInt(99999999) + "");

		int row = studentRepo.makePayment(payment);
		if (row == 0)
			throw new PaymentFaildException();
		return new Notification("Payment of Rs " + payment.getPaymentFee() + " was successful");
	}

	/**
	 * Method to fetchPayment
	 * 
	 * @param studentId
	 * @throws PaymentNotFoundException
	 * @return payment
	 */
	public List<Payment> fetchPayment(String fetchPaymentJson) throws PaymentNotFoundException {
		JSONObject paymentJson = new JSONObject(fetchPaymentJson);
		String studentId = paymentJson.getString("studentId");
		List<Payment> payment = studentRepo.fetchPayment(studentId);
		if (payment.size() == 0)
			throw new PaymentNotFoundException();
		return payment;
	}

}
