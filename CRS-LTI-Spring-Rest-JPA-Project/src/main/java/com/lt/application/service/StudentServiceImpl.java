package com.lt.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.application.entity.Course;
import com.lt.application.entity.Notification;
import com.lt.application.entity.Payment;
import com.lt.application.entity.Student;
import com.lt.application.entity.StudentCourse;
import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.exception.PaymentFaildException;
import com.lt.application.exception.PaymentNotFoundException;
import com.lt.application.exception.ViewGradeException;
import com.lt.application.repository.CourseRepository;
import com.lt.application.repository.PaymentRepository;
import com.lt.application.repository.PaymentRepository.PaymentResponse;
import com.lt.application.repository.StudentCourseRepository;
import com.lt.application.repository.StudentCourseRepository.ViewGrades;
import com.lt.application.repository.StudentRepository;

/**
 * @author Shahul
 * 
 *         This is implementetion class of StudentService
 */
@Service
public class StudentServiceImpl implements StudentService {

	private static Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	StudentCourseRepository studentCourseRepository;
	@Autowired
	CourseRepository courseRepository;
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
		log.info("Returning course remove successfully");
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
		log.info("Entering gradeList from student service");
		List<ViewGrades> gradeList = studentCourseRepository.findByStudentId(studentId);

		log.info("Returning gradelist from student service");
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
		log.info("Entering addCourse from student service");
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

		log.info("Returning added course from Student Service Implementation");
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
		log.info("Entering make payment from student service");
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

		log.info("Returning payment successful notification from student service");
		return new Notification("Payment of Rs " + payment.getPaymentFee() + " was successful");

	}

	/**
	 * Method to fetchPayment
	 * 
	 * @param studentId
	 * @throws PaymentNotFoundException
	 * @return {@link PaymentResponse}
	 */
	public List<PaymentResponse> fetchPayment(String fetchPaymentJson) throws PaymentNotFoundException {
		log.info("Entering fetch payment from student service");
		String studentId = new JSONObject(fetchPaymentJson).getString("studentId");
		List<PaymentResponse> payment = paymentRepository.findByStudent_Id(studentId);
		if (payment == null)
			throw new PaymentNotFoundException();

		log.info("Returning payment from student service");
		return payment;

	}

}
