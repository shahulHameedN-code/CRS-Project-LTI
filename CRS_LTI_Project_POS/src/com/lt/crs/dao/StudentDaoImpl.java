package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.intrfc.StudentDao;
import com.lt.crs.util.DBConnection;

/**
 * The class StudentDaoImpl implements StudentDao
 */

/**
 * 
 * @author Jeaswanth
 * 
 * 
 */
public class StudentDaoImpl implements StudentDao {

	private Connection con = null;
	private static Logger log = Logger.getLogger(StudentDaoImpl.class);

	/**
	 *
	 * StudentDaoImpl
	 *
	 * @return public
	 */
	public StudentDaoImpl() {
		log.debug("Getting DB connection");
		con = DBConnection.getDBConnection();

	}

	@Override

	/**
	 *
	 * Add course
	 *
	 * @param courseList the course list
	 * @param studentId  the student identifier
	 */
	public void addCourse(List<Course> courseList, String studentId) {

		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		log.debug("Adding courses to the student with ID:" + studentId + " on calling addCourse() method");
		try {
			String sql = "insert into studentcourse (student_id,course_id) values(?,?)";
			ps = con.prepareStatement(sql);
			for (Course c : courseList) {
				ps.setString(1, studentId);
				ps.setString(2, c.getId());
				ps.execute();
			}
			log.debug("List of courses were registered for the student withID:" + studentId);
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {

			try {
				ps.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

	}

	/**
	 *
	 * Close connection
	 *
	 */
	public void closeConnection() {

		try {
			con.close();
			log.debug("Closing the DB connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
	}

	@Override

	/**
	 *
	 * Drop course
	 *
	 * @param studentId the student identifier
	 * @param courseId  the course identifier
	 */
	public void dropCourse(String studentId, String courseId) {

		PreparedStatement stmt = null;
		log.debug("Dropping a course with ID:" + courseId + " for the student with Id:" + studentId
				+ " on calling dropCourse() method");
		try {
			String sql = "delete from studentcourse where student_id=? and course_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			stmt.setString(2, courseId);
			stmt.executeUpdate();
			log.debug(" Course with ID:" + courseId + " was dropped for the student with Id:" + studentId);
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();
				log.debug("Closing the DB connection");

			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}

	}

	/**
	 *
	 * View enrolled courses
	 *
	 * @param studentId the student identifier
	 * @return List<Course>
	 */
	public List<Course> viewEnrolledCourses(String studentId) {

		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Course> courseList = new ArrayList<Course>();
		log.debug("Retriving the enrolled courses for a student with ID:" + studentId
				+ " on calling viewEnrolledCourses() method");
		try {
			String sql = "select * from studentcourse sc inner join course c on c.course_id=sc.course_id where student_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Course c = new Course();
				c.setId(rs.getString("course_id"));
				c.setName(rs.getString("course_name"));
				courseList.add(c);
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();
				log.debug("Closing the DB connection");

			} catch (SQLException e) {
				log.error(e.getMessage());
			}
		}
		log.debug("List of courses for the student with ID:" + studentId + " was returned");
		return courseList;
	}

	/**
	 *
	 * View grade
	 *
	 * @param studentId the student identifier
	 * @return Student
	 */
	@Override
	public Student viewGrade(String studentId) {

		Student getStudentcourseList = new Student();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		log.debug("retrieving grades for a student with ID:" + studentId + " on calling viewGrade() method");
		try {

			String sql = "select * from studentcourse sc inner join course c on c.course_id=sc.course_id where sc.student_id=? ";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			rs = stmt.executeQuery();
			List<Course> courseList = new ArrayList<Course>();
			while (rs.next()) {

				Course c = new Course();
				c.setId(rs.getString("course_id"));
				c.setName(rs.getString("course_name"));
				c.setGrade(rs.getString("grade"));
				courseList.add(c);
			}
			getStudentcourseList.setCourseList(courseList);
			log.debug("Grades were returned for the student");
			return getStudentcourseList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();
				rs.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}
		log.debug("Grades were returned for the student");
		return getStudentcourseList;

	}

	public int viewTotalAmount(String studentId) {

		PreparedStatement stmt = null;
		ResultSet rs = null;

		int totalFeeAmount = 0;
		try {
			String sql = "select sum(c.paymentfee) as paymentFee from studentcourse sc inner join course c on c.course_id=sc.course_id where student_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, studentId);
			rs = stmt.executeQuery();

			while (rs.next()) {

				totalFeeAmount += rs.getInt("paymentFee");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return totalFeeAmount;

	}
}
