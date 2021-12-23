package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.intrfc.LoginDao;
import com.lt.crs.util.DBConnection;

/**
 * 
 * @author Shahul
 * 
 * 
 */

/**
 * The class LoginDaoImpl implements loginDao
 */
public class LoginDaoImpl implements LoginDao {

	Connection con = null;
	private static Logger log = Logger.getLogger(LoginDaoImpl.class);

	/**
	 *
	 * Login dao impl
	 *
	 * @return
	 */
	public LoginDaoImpl() {

		// TODO Auto-generated constructor stub
		log.debug("Getting DB connection");
		con = DBConnection.getDBConnection();
	}

	@Override

	/**
	 *
	 * THE Method Isauthenticated
	 *
	 * @param username : the username
	 * @param password :the password
	 * @return boolean
	 */
	public boolean isAuthenticated(String username, String password) {

		// TODO Auto-generated method stub
		log.debug("Checking whether the user is authenticated");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where username=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			log.debug("User was authenticated");
			return rs.first();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		return false;
	}

	/**
	 *
	 * Isauthenticated student
	 *
	 * @param username the username
	 * @param password the password
	 * @return Student
	 */
	public Student isAuthenticatedStudent(String username, String password) {

		// TODO Auto-generated method stub
		log.debug("Checking whether the student is authenticated");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where username=? and password=? and isapproved=true";
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				Student s = new Student();

				s.setId(rs.getString("userId"));
				s.setName(rs.getString("username"));
				log.debug("Returning the Student object value based on the authentication");
				return s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		return null;
	}

	/**
	 *
	 * Is professor authenticated
	 *
	 * @param username the username
	 * @param password the password
	 * @return Professor
	 */
	public Professor isProfessorAuthenticated(String username, String password) {

		// TODO Auto-generated method stub
		log.debug("Checking whether the professor is authenticated");
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select * from user where username=? and password=?";
			ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				Professor s = new Professor();

				s.setName(rs.getString("username"));
				log.debug("Returning the Professor object value based on the authentication");
				return s;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				ps.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		return null;
	}

	public int updatePassword(String userId, String password, String newPassword) {

		// TODO Auto-generated method stub
		log.debug("Entering Update Password");
		PreparedStatement ps = null;

		int update = 0;
		try {
			String sql = "update user set password=? where userId=? and password=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, newPassword);
			ps.setString(2, userId);
			ps.setString(3, password);
			update = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				ps.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		return update;
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
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

	}

}
