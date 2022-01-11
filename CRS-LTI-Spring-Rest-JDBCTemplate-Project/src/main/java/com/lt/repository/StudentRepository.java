package com.lt.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lt.bean.Course;
import com.lt.bean.Payment;
import com.lt.bean.StudentRegistration;
import com.lt.constant.SQLConstant;
import com.lt.rowmapper.PaymentRowMapper;
import com.lt.rowmapper.StudentGradeRowMapper;

/**
 * @author Shahul
 *
 */

/**
 * @author Shahul that an @Repository annotated class is a “Repository” define
 *         instantiation, configuration, and initialization logic for objects.
 */

@Repository
public class StudentRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * This is registerStudent method
	 * 
	 * @param name
	 * @param id
	 * @param address
	 * @param email
	 * @return student
	 */

	public String registerStudent(StudentRegistration student) {
		// TODO Auto-generated method stub

		jdbcTemplate.update(SQLConstant.REGISTER_STUDENT, student.getName(), student.getId(), student.getAddress(),
				student.getEmail());
		jdbcTemplate.update(SQLConstant.REGISTER_USER, student.getName(), student.getPassword(), student.getId(),
				false);

		return "Student " + student.getName() + " registered successfully!! Admin Approval Pending";
	}

	/**
	 * This is addCourse method add the course into list
	 * 
	 * @param studentId
	 * @param courseId
	 * @exception SQLException
	 * @return studentCourseList
	 */
	public String addCourse(ArrayList<JSONObject> studentCourseList) {

		jdbcTemplate.batchUpdate(SQLConstant.ADD_COURSE, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				JSONObject jso = studentCourseList.get(i);
				ps.setString(1, jso.getString("studentId"));
				ps.setString(2, jso.getString("courseId"));

			}

			@Override
			public int getBatchSize() {
				return studentCourseList.size();
			}

		});

		return "Courses Added Successfully";
	}

	/**
	 * This is removeCourse method remove the course from list
	 * 
	 * @param studentId
	 * @param courseId
	 * @return row
	 */
	public int removeCourse(String studentId, String courseId) {

		int row = jdbcTemplate.update(SQLConstant.DELETE_COURSE, studentId, courseId);

		return row;

	}

	/**
	 * This is viewGrades method
	 * 
	 * @param studentId
	 * @return courseList
	 */
	public List<Course> viewGrades(String studentId) {

		List<Course> courseList = jdbcTemplate.query(SQLConstant.VIEW_GRADES, new Object[] { studentId },
				new StudentGradeRowMapper());
		return courseList;
	}

	/**
	 * This is makePayment method
	 * 
	 * @param studentId
	 * @return paymentId
	 * @param PaymentFee
	 * @return row
	 */
	public int makePayment(Payment payment) {

		int row = jdbcTemplate.update(SQLConstant.MAKE_PAYMENT, payment.getPaymentId(), payment.getStudentId(),
				payment.getPaymentFee());

		return row;
	}

	public List<Payment> fetchPayment(String studentId) {

		List<Payment> paymentList = jdbcTemplate.query(SQLConstant.FETCH_PAYMENT, new Object[] { studentId },
				new PaymentRowMapper());

		return paymentList;
	}

}
