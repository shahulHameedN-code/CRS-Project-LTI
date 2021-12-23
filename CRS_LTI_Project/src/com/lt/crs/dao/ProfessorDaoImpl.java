package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Department;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.exception.AddProfessorException;
import com.lt.crs.intrfc.ProfessorDao;
import com.lt.crs.util.DBConnection;



/**
 * 
 * @author Jeaswanth
 * 
 * 
 */

/**
 * The class ProfessorDaoImpl implements professordao
 */
public class ProfessorDaoImpl implements ProfessorDao {

	Connection con = null;
	private static Logger log = Logger.getLogger(ProfessorDaoImpl.class);

	/**
	 *
	 * Professor DAOImpl
	 *
	 */
	public  ProfessorDaoImpl() {

		// TODO Auto-generated constructor stub

		log.debug("Getting DB connection");
		this.con = DBConnection.getDBConnection();
		
		System.out.println("Con ---------> "+con.toString());

	}

	/**
	 *
	 */
	public void addGrades(String csId, String stdId, String grade) {

		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		log.debug("Calling the addGrades() method to enter the grades for the students");
		try {

			String s = "update studentcourse sc set grade=? where sc.student_id=? and sc.course_id=?;";
			System.out.println("grade -------------------------> " + grade);
			statement = con.prepareStatement(s);
			statement.setString(1, grade);
			statement.setString(2, stdId);
			statement.setString(3, csId);
			statement.executeUpdate();
			log.debug("Grades were added successfully");
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				statement.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

	}

	@Override

	/**
	 *
	 * Save professor
	 *
	 * @param p the Professor
	 * @throws AddProfessorException
	 */
	public void saveProfessor(Professor p) throws AddProfessorException {

		PreparedStatement stmt = null;
		log.debug("Calling SaveProfessor() method for addition of new professor");
		try {
			validateProfessor(p);

			String sql = "insert into professor(name,id,department_id) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, p.getName());
			stmt.setString(2, p.getId());
			stmt.setString(3, p.getDepartment().getId());
			stmt.executeUpdate();
			log.debug("Addition of new professor was done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

	}

	@Override

	/**
	 *
	 * Close connection
	 *
	 */
	public void closeConnection() {

		try {
			log.debug("Closing the DB connection");
			if(con!=null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

	}

	/**
	 *
	 * Fetch professor
	 *
	 * @returns List<Professor> returns the list
	 */
	public List<Professor> fetchProfessor() {

		List<Professor> professor = new ArrayList<Professor>();
		Statement statement = null;
		ResultSet rs = null;
		log.debug("Fetching all the professors from DB");
		try {

			statement = con.createStatement();
			String s = "SELECT * FROM professor";

			rs = statement.executeQuery(s);

			while (rs.next()) {
				Professor p = new Professor();
				p.setId(rs.getString("id"));
				p.setName(rs.getString("name"));

				professor.add(p);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				statement.close();
				rs.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		log.debug("List of professors is returned");
		return professor;

	}

	/**
	 *
	 * Validate professor
	 *
	 * @param professor the professor
	 * @return boolean
	 * @throws AddProfessorException if professor already exists
	 */
	public boolean validateProfessor(Professor professor) throws AddProfessorException {

		PreparedStatement statement = null;
		ResultSet rs = null;
		log.debug("Validating whether the professor is already existing one");
		try {
			String s = "SELECT * FROM professor where id=?";
			statement = con.prepareStatement(s);
			statement.setString(1, professor.getId());
			rs = statement.executeQuery();
			if (rs.first())
				throw new AddProfessorException("Professor already exists");

		} catch (AddProfessorException e) {
			log.error(e.getMessage());
		} catch (SQLException e) {
			log.error(e.getMessage());
		} finally {
			try {
				statement.close();
				rs.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}
		log.debug("Professor was not part of the organisation earlier");
		return false;

	}

	@Override

	/**
	 *
	 * View enrolled students
	 *
	 * @param courseId the course identifier
	 * @return List<Student>
	 */
	public List<Student> viewEnrolledStudents(String courseId) {

		ArrayList<Student> student = new ArrayList<Student>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		log.debug("Retrieving the students enrolled for a course with courseId:" + courseId);
		try {
			String sql = "select * from student s inner join studentcourse sc on s.id=sc.student_id where sc.course_id=?";
			statement = con.prepareStatement(sql);
			statement.setString(1, courseId);
			rs = statement.executeQuery();
			while (rs.next()) {
				Student s = new Student();
				Department d = new Department();
				s.setId(rs.getString("id"));
				s.setName(rs.getString("name"));
				d.setName(rs.getString("departmentId"));
				s.setDepartment(d);
				student.add(s);
			}

		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			try {
				if (statement != null)
					statement.close();
				if (rs != null)
					rs.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}
		log.debug("List of enrolled students for the course with courseID:" + courseId + " were returned");
		return student;
	}
}
