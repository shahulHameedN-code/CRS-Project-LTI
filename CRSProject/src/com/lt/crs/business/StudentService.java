package com.lt.crs.business;

import org.apache.log4j.Logger;

import com.lt.crs.bean.StudentRegistration;
import com.lt.crs.dao.StudentRegisterDaoImpl;
import com.lt.crs.exception.EnrolledStudentsException;


/**
 * 
 * @author Bhuvaneshwari
 * 
 * 
 */
public class StudentService {

	private static Logger log = Logger.getLogger(StudentService.class);

	/**
	 * Method to register a student
	 * 
	 * @param Register:StudentRegistration
	 */
	public void studentRegisteration(StudentRegistration Register) {
		log.debug("Entering Student Registration");

		StudentRegisterDaoImpl daoRegister = new StudentRegisterDaoImpl();
		daoRegister.saveStudentRegister(Register);
		daoRegister.closeConnection();
		log.debug("returning from Student Registration");
	}

}
