package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.crs.bean.StudentRegistration;
import com.lt.crs.intrfc.StudentRegisterDao;
import com.lt.crs.util.DBConnection;



/**
 * 
 * @author Bhuvaneshwari
 * 
 * 
 */

/**
 * The class StudentRegisterDaoImpl implements studentRegisterDao
 */
public class StudentRegisterDaoImpl implements StudentRegisterDao {

	Connection con = null;
	private static Logger log = Logger.getLogger(StudentRegisterDaoImpl.class);

	/**
	 *
	 * Student register dao impl
	 *
	 * @return
	 */
	public StudentRegisterDaoImpl() {

		// TODO Auto-generated constructor stub
		this.con = DBConnection.getDBConnection();
		log.debug("Getting the DB connection");
	}

	@Override

	/**
	 *
	 * Save student register
	 *
	 * @param register
	 */
	public void saveStudentRegister(StudentRegistration register) {

		PreparedStatement stmt = null;
		log.debug("Student is getting registered on calling saveStudentRegister() method");
		try {
			String sql = "insert into student(id,name,address) values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, register.getId());
			stmt.setString(2, register.getName());
			stmt.setString(3, register.getAddress());
			stmt.execute();
			stmt.close();
			passwordRegisteration(register);
			log.debug("Student was registered");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}
		// TODO Auto-generated method stub

	}

	/**
	 *
	 * Password registeration
	 *
	 * @param register
	 */
	@Override
	public void passwordRegisteration(StudentRegistration register) {
		// TODO Auto-generated method stub
		log.debug("Saving the credentials of the new student");
		PreparedStatement stmt = null;

		try {
			String sql = "insert into user(userId,username,password,isapproved) values(?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, register.getId());
			stmt.setString(2, register.getName());
			stmt.setString(3, register.getPassword());
			stmt.setBoolean(4, false);

			stmt.execute();
			log.debug("New student credentials were saved successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}
		// TODO Auto-generated method stub

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

}
