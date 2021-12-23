package com.lt.crs.business;

import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.StudentRegistration;
import com.lt.crs.dao.StudentDaoImpl;
import com.lt.crs.dao.StudentRegisterDaoImpl;
import com.lt.crs.exception.RemoveCourseException;
import com.lt.crs.intrfc.StudentService;

/**
 * The class Student service impl implements student service
 */

/**
 * 
 * @author Shahul
 * 
 * 
 */
public class StudentServiceImpl implements StudentService {

	private static Logger log = Logger.getLogger(StudentServiceImpl.class);

	@Override

	/**
	 *
	 * Student registeration
	 *
	 * @param Register the register
	 */
	public void studentRegisteration(StudentRegistration Register) {
		log.debug("Entering Student Registration");
		StudentRegisterDaoImpl daoRegister = new StudentRegisterDaoImpl();
		daoRegister.saveStudentRegister(Register);
		daoRegister.closeConnection();
		log.debug("returning Student Registration");
	}

	@Override

	/**
	 *
	 * Drop course
	 *
	 * @param studentId the student identifier
	 * @param courseId  the course identifier
	 * @throws RemoveCourseException
	 */
	public void dropCourse(String studentId, String courseId) throws RemoveCourseException {
		log.debug("Entering drop course");
		StudentDaoImpl studentdao = new StudentDaoImpl();
		studentdao.dropCourse(studentId, courseId);
		studentdao.closeConnection();
		log.debug("returning drop course");
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
		log.debug("Entering add course");
		StudentDaoImpl sdi = new StudentDaoImpl();
		sdi.addCourse(courseList, studentId);
		sdi.closeConnection();
		log.debug("returning from add course");
	}

	@Override

	/**
	 *
	 * View enrolled courses
	 *
	 * @param studentId the student identifier
	 * @return List<Course>
	 */
	public List<Course> viewEnrolledCourses(String studentId) {
		log.debug("Entering view Enrolled Courses");
		StudentDaoImpl studentdao = new StudentDaoImpl();
		List<Course> course = studentdao.viewEnrolledCourses(studentId);
		studentdao.closeConnection();
		log.debug("returning from view Enrolled Courses");
		return course;
	}

	public int viewTotalAmount(String studentId) {
		log.debug("Entering view Total Amount");
		StudentDaoImpl studentdao = new StudentDaoImpl();
		int totalFeeAmount = studentdao.viewTotalAmount(studentId);
		studentdao.closeConnection();
		log.debug("returning from view Total amount");
		return totalFeeAmount;
	}

	@Override

	/**
	 *
	 * View grades
	 *
	 * @param studentId the student identifier
	 * @return Student
	 */
	public Student viewGrades(String studentId) {
		log.debug("Entering View Grades");
		Student studentGrades = null;
		StudentDaoImpl sdi = new StudentDaoImpl();
		studentGrades = sdi.viewGrade(studentId);
		sdi.closeConnection();
		log.debug("returning from view Grades");
		return studentGrades;

	}

}
