package com.lt.crs.business;

import java.util.Formatter;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Student;
import com.lt.crs.dao.ProfessorDaoImpl;
import com.lt.crs.exception.AddGradesException;
import com.lt.crs.exception.EnrolledStudentsException;

/**
 * 
 * @author Jeaswanth Professor Business Operations
 * 
 */
public class ProfessorServiceImpl {

	private static Logger log = Logger.getLogger(ProfessorServiceImpl.class);

	/**
	 * Method to grade a Student
	 * 
	 * @param studentId
	 * @param courseCode
	 * @param grade
	 * 
	 * @throws AddGradesException
	 */

	public void addGrades(String csId, String stdId, String grade) throws AddGradesException {
		log.debug("Entering add grades");
		ProfessorDaoImpl pdi = new ProfessorDaoImpl();
		pdi.addGrades(csId, stdId, grade);
		pdi.closeConnection();
		log.debug("returning from add grades");

	}

	/**
	 * Method to view all the enrolled students
	 * 
	 * @param CourseId: course id
	 * @throws EnrolledStudentsException
	 * @return List of enrolled students
	 */

	public void viewEnrolledStudents(String courseId) throws EnrolledStudentsException {
		// TODO Auto-generated method stub
		log.debug("Entering view enrolled students");
		final Formatter fmt = new Formatter();
		ProfessorDaoImpl pdi = new ProfessorDaoImpl();
		List<Student> studentList = pdi.viewEnrolledStudents(courseId);
		System.out.println("Enrolled students for the course: " + courseId);

		fmt.format("%15s %15s %15s\n", "Student Name", "Student Id", "Student Department");

		studentList.forEach(c -> {

			fmt.format("%14s %14s %17s\n", c.getName() + "|", c.getId() + "|", c.getDepartment().getName());

		});
		System.out.println(fmt);

		pdi.closeConnection();
		log.debug("returning from view enrolled students");
	}

}
