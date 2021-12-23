package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.intrfc.CourseDao;
import com.lt.crs.util.DBConnection;

/**
 * 
 * @author Mano
 *  Class to implement CourseDaoImpl Operations
 *
 */
public class CourseDaoImpl implements CourseDao {

	private static Logger log = Logger.getLogger(CourseDaoImpl.class);

	Connection con = null;

	/**
	 * Default Constructor
	 */

	public CourseDaoImpl() {

		// TODO Auto-generated constructor stub
		this.con = DBConnection.getDBConnection();

	}

	/**
	 * Method to add Course to database
	 * 
	 * @param course: Course object containing all the fields
	 * @throws SQLException
	 */

	@Override
	public void addCourse(Course course) {
		log.debug("Entering add course dao layer");
		PreparedStatement stmt = null;

		try {
			String sql = "insert into course(course_id,course_name,noofstudents) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, course.getId()); // This would set age
			stmt.setString(2, course.getName());
			// stmt.setString(3, course.getGrade());
			stmt.setInt(3, course.getNoOfStudents());
			stmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("returning add course dao layer");
		// TODO Auto-generated method stub

	}

	/**
	 * Method to remove Course from database
	 * 
	 * @param course:courseid
	 * @throws SQLException
	 */

	@Override
	public void removeCourse(String courseId) {
		log.debug("Entering remove course dao layer");
		PreparedStatement stmt = null;

		try {
			String sql = "delete from course WHERE course_id=?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, courseId);
			stmt.executeUpdate();

			System.out.println("Selected course with id: " + courseId + " was removed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("returning  remove course dao layer");
	}

	/**
	 * Method to fetch allCourse from database
	 * 
	 * @return courses
	 * @throws SQLException
	 */

	@Override
	public List<Course> fetchCourse() {
		log.debug("Entering fetch course dao layer");

		ArrayList<Course> courses = new ArrayList<Course>();
		Statement statement = null;
		ResultSet rs = null;
		try {

			statement = con.createStatement();
			String s = "SELECT * FROM course";

			rs = statement.executeQuery(s);

			while (rs.next()) {
				Course course = new Course();
				course.setId(rs.getString("course_id"));
				course.setName(rs.getString("course_name"));
				course.setNoOfStudents(rs.getInt("noofstudents"));

				courses.add(course);
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				statement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("returning fetch course dao layer");
		return courses;
	}

	@Override

	/**
	 *
	 * Fetch course
	 *
	 * @param course the course
	 * @return Course
	 */
	public Course fetchCourse(Course course) {
		log.debug("Entering fetch course dao layer");
		Course addcourse = null;
		PreparedStatement statement = null;

		ResultSet rs = null;
		try {
			String sql = "select * from course where course_name =?";
			statement = con.prepareStatement(sql);
			statement.setString(1, course.getName());
			rs = statement.executeQuery();
			if (rs.next()) {
				addcourse = new Course();
				addcourse.setId(rs.getString(1));
				addcourse.setName(rs.getString(2));
				addcourse.setNoOfStudents(rs.getInt(3));
			} else
				System.out.println("CourseName doesnot exist");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		log.debug("returning fetch course dao layer");
		return addcourse;
	}

	@Override

	/**
	 *
	 * Close connection
	 *
	 */
	public void closeConnection() {

		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
