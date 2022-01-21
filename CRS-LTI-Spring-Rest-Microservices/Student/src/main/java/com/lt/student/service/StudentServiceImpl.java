package com.lt.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.student.beans.Course;
import com.lt.student.beans.Notification;
import com.lt.student.beans.Payment;
import com.lt.student.beans.Student;
import com.lt.student.beans.StudentCourse;
import com.lt.student.exception.CourseNotFoundException;
import com.lt.student.exception.PaymentFaildException;
import com.lt.student.exception.PaymentNotFoundException;
import com.lt.student.exception.ViewGradeException;
import com.lt.student.repository.PaymentRepository;
import com.lt.student.repository.PaymentRepository.PaymentResponse;
import com.lt.student.repository.StudentCourseRepository;
import com.lt.student.repository.StudentCourseRepository.ViewGrades;
import com.lt.student.repository.StudentRepository;

/**
 * @author Shahul
 * 
 *         This is implementetion class of StudentService
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	StudentCourseRepository studentCourseRepository;
	@Autowired
	PaymentRepository paymentRepository;

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
		int row = studentCourseRepository.deleteByStudentIdAndCourseId(studentId, courseId);

		if (row == 0)
			throw new CourseNotFoundException();
		return "course removed succesfully";

	}

	/**
	 * Method to viewGrades
	 * 
	 * @param studentId
	 * @throws ViewGradeException
	 * @return {@link ViewGrades}
	 */
	public List<ViewGrades> viewGrades(String studentId) throws ViewGradeException {
		List<ViewGrades> gradeList = studentCourseRepository.findByStudentId(studentId);
		System.out.println(gradeList.toString());

		return gradeList;

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
		ArrayList<StudentCourse> studentCourseList = new ArrayList<>();
		for (int i = 0; i < jsa.length(); i++) {
			StudentCourse sc = new StudentCourse();
			Course c = new Course();
			c.setCourseId(jsa.getJSONObject(i).getString("courseId"));

			Student s = new Student();
			s.setStudentId(jsonObj.getString("studentId"));

			sc.setCourse(c);
			sc.setStudent(s);
			studentCourseList.add(sc);

		}
		studentCourseRepository.saveAll(studentCourseList);

		return "CourseAdded";

	}

	/**
	 * Method to makePayment
	 * 
	 * @param studentId
	 * @param cardNumber
	 * @param paymentFee
	 * @param cvvNumber
	 * @param pin
	 * @return {@link Notification}
	 */

	public Notification makePayment(String makePaymentJson) throws PaymentFaildException {
		Random r = new Random();
		JSONObject jso = new JSONObject(makePaymentJson);
		Payment payment = new Payment();

		Student s = new Student();
		s.setStudentId(jso.getString("studentId"));

		payment.setPaymentFee(jso.getInt("paymentFee"));

		payment.setPaymentId(r.nextInt(99999999) + "");
		payment.setStudent(s);
		Payment payRes = paymentRepository.save(payment);
		if (payRes == null)
			throw new PaymentFaildException();

		return new Notification("Payment of Rs " + payment.getPaymentFee() + " was successful");

	}

	/**
	 * Method to fetchPayment
	 * 
	 * @param studentId
	 * @throws PaymentNotFoundException
	 * @return {@link PaymentResponse}
	 */
	public List<PaymentResponse> fetchPayment(String studentId) throws PaymentNotFoundException {

		List<PaymentResponse> payment = paymentRepository.findByStudent_Id(studentId);
		if (payment == null)
			throw new PaymentNotFoundException();

		return payment;

	}

}
