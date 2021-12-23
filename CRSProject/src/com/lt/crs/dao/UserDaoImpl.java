package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Student;
import com.lt.crs.intrfc.UserDao;
import com.lt.crs.util.DBConnection;



/**
 * 
 * @author Mano
 * 
 * 
 */

/**
 * The class User dao impl implements user dao
 */ 
public class UserDaoImpl implements UserDao {

	Connection con = null;
	private static Logger log = Logger.getLogger(UserDaoImpl.class);
	
	/** 
	 *
	 * Userdaoimpl
	 *
	 * @return 	
	 */
	public UserDaoImpl() { 

		// TODO Auto-generated constructor stub
		con = DBConnection.getDBConnection();
		log.debug("Getting the DB connection");
	}

	@Override

	/** 
	 *
	 * method approveRegistration
	 *
	 * @param student : the student
	 */
	public void approveRegistration(Student student) { 


		// TODO Auto-generated method stub
		PreparedStatement statement = null;
		log.debug("approveRegistration() was called for approving the new registered student by Admin");
		try {

			String s = "update user set isApproved=true where userid=?";

			statement = con.prepareStatement(s);
			statement.setString(1, student.getId());
			statement.executeUpdate();
			log.debug("Given student with ID:" + student.getId() + " was approved");
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
	 * Gets the pending approval students
	 *
	 * @return the pending approval students list
	 */
	public List<Student> getPendingApprovalStudents() { 

		// TODO Auto-generated method stub
		log.debug("getPendingApprovalStudents() method was called for getting the students whose registration is not approved");
		ArrayList<Student> studentList = new ArrayList<Student>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {

			String s = "select s.*,u.isApproved from student s inner join user u on s.id=u.userid where isApproved=false";
			statement = con.prepareStatement(s);
			rs = statement.executeQuery();

			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getString("id"));
				student.setName(rs.getString("name"));
				student.setAddress(rs.getString("address"));
				student.setApproved(rs.getBoolean("isApproved"));
				studentList.add(student);
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
		log.debug("Returned a list of students whose approval is still pending");
		return studentList;

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
			log.debug("Closing the DB connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

	}

}
