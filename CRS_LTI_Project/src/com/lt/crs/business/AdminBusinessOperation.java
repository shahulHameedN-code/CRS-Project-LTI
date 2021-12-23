package com.lt.crs.business;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.dao.CourseDaoImpl;
import com.lt.crs.dao.ProfessorDaoImpl;
import com.lt.crs.dao.UserDaoImpl;
import com.lt.crs.exception.AddProfessorException;
import com.lt.crs.exception.RemoveCourseException;
import com.lt.crs.exception.SaveCourseException;
import com.lt.crs.exception.UserNotApprovedException;

/**
 * 
 * @author Shahul AdminBusinessOperations
 * 
 */
public class AdminBusinessOperation {

	private static Logger log = Logger.getLogger(AdminBusinessOperation.class);

	List<Course> courseList = new ArrayList<>();

	List<Professor> professorList = new ArrayList<Professor>();

	/**
	 * Method to save Course from Course tab
	 * 
	 * @param courseid
	 * @param courseList : Courses available in coiurse tab
	 * @throws SaveCourseException
	 */

	public void SaveCourse(Course c) throws SaveCourseException {
		log.debug("Entering Save Course");
		CourseDaoImpl cdi = new CourseDaoImpl();
		cdi.addCourse(c);
		cdi.closeConnection();
		log.debug("returning from Save Course");

	}

	/**
	 * Method to fetch Course from Course tab
	 * 
	 * @param course     : Course object storing details of a course
	 * @param courseList : Courses available in course tab
	 * @return courseList
	 */

	public List<Course> fetchCourse() {
		log.debug("Entering fetch Course");
		CourseDaoImpl cdi = new CourseDaoImpl();
		List<Course> courseList = cdi.fetchCourse();
		cdi.closeConnection();
		log.debug("returning from fetch Course");
		return courseList;

	}

	/**
	 * Method to save Professor toProfessorTab
	 * 
	 * @param course : Professor object storing details of a Professor
	 * 
	 * @throws AddProfessorException
	 */

	public void saveProfessor(Professor p) throws AddProfessorException {
		log.debug("Entering Save professor");
		ProfessorDaoImpl pdi = new ProfessorDaoImpl();
		pdi.saveProfessor(p);
		pdi.closeConnection();
		log.debug("returning from save professor");

	}

	/**
	 * Method to remove course from CourseTab
	 * 
	 * @param course : Course object storing details of a Course
	 * 
	 * @throws RemoveCourseException
	 */

	public void removeCourse() throws RemoveCourseException {
		log.debug("Entering remove Course");
		final Formatter fmt = new Formatter();
		CourseDaoImpl cdi = new CourseDaoImpl();
		List<Course> courseList = cdi.fetchCourse();
		System.out.println("======== Course Deletion page ========");
		System.out.println("==============================");
		System.out.println("-------Existing Courses-------");
		System.out.println("==============================");

		fmt.format("%15s %15s \n", "Course Name", "Course Id");

		courseList.forEach(c -> {

			fmt.format("%14s %14s \n", c.getName() + "|", c.getId());

		});
		System.out.println(fmt);

		System.out.println("----------------------------------");
		System.out.println("Enter the course Id to be removed:");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		cdi.removeCourse(id);
		cdi.closeConnection();

		System.out.println("=================================");
		System.out.println("-------Updated Course List-------");
		System.out.println("=================================");
		cdi = new CourseDaoImpl();

		fmt.format("%15s %15s \n", "Course Name", "Course Id");

		cdi.fetchCourse().forEach(c -> {

			fmt.format("%14s %14s \n", c.getName() + "|", c.getId());

		});
		System.out.println(fmt);

		cdi.closeConnection();

		log.debug("returning from remove Course");

	}

	/**
	 * Method to fetch list of professor in catalog
	 * 
	 * @param professor
	 * @return List of professor
	 */

	public List<Professor> fetchProfessor() {
		log.debug("Entering fetch professor");
		ProfessorDaoImpl pdi = new ProfessorDaoImpl();
		List<Professor> professorList = pdi.fetchProfessor();
		pdi.closeConnection();
		log.debug("returning from fetch professor");
		return professorList;

	}

	/**
	 * Method to approve a Student
	 * 
	 * @param studentId
	 * @param studentList
	 * @throws UserNotApprovedException
	 * 
	 *                                  * Method to check if student is approved by
	 *                                  Admin or not
	 * @param studentId
	 * @return boolean indicating if student is approved
	 */

	public void approveRegisteredStudents(Student s) throws UserNotApprovedException {
		log.debug("Entering approve Registered Students");
		UserDaoImpl udi = new UserDaoImpl();
		udi.approveRegistration(s);
		udi.closeConnection();
		log.debug("returning from approve registered students ");

		// TODO Auto-generated method stub

	}

	/**
	 * Method to approve a Student
	 * 
	 * @param studentId
	 * 
	 * @return studentList
	 */
	public List<Student> getPendingApprovalStudents() {
		log.debug("Entering get pending approval students");
		UserDaoImpl udi = new UserDaoImpl();
		List<Student> studentList = udi.getPendingApprovalStudents();
		udi.closeConnection();
		log.debug("returning from pending approval students");
		return studentList;

	}

}
