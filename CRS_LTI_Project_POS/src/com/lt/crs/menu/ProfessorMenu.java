package com.lt.crs.menu;

import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;
import com.lt.crs.business.AdminBusinessOperation;
import com.lt.crs.business.ProfessorServiceImpl;
import com.lt.crs.dao.LoginDaoImpl;
import com.lt.crs.exception.AddGradesException;
import com.lt.crs.exception.EnrolledStudentsException;
import com.lt.crs.exception.InvalidCredentailsException;
import com.lt.crs.intrfc.Menu;

/**
 * 
 * @author Jeaswanth
 * 
 * 
 */

/**
 * The class Professor menu implements menu
 */
public class ProfessorMenu implements Menu {

	@Override
	public void menu() {
		// TODO Auto-generated method stub
		ProfessorServiceImpl psi = new ProfessorServiceImpl();
		AdminBusinessOperation abo = new AdminBusinessOperation();
		final Formatter fmt = new Formatter();
		String userName = "";
		String password = "";
		Scanner in = new Scanner(System.in);
		Professor professor = null;
		boolean login = false;
		while (true) {

			if (professor == null) {
				System.out.println("\n\n~~~~~~ Welcome to Course Registration System - Professor Page ~~~~~~");
				System.out.println("----------------------------------------------------------------");
				System.out.println("\t\tPlease login to continue");
				System.out.println("UserName:");
				userName = in.next();
				System.out.println("Password:");
				password = in.next();
				try {
					professor = loginProfessor(userName, password);
				} catch (InvalidCredentailsException e) {
					System.out.println(e.getMessage());
				}
			}

			if (professor != null) {
				System.out.println("----------------------------------------------------------------");
				LocalDateTime localDateTime = LocalDateTime.now();
				System.out.println(
						"Hi " + professor.getName().toUpperCase() + ",\n\tWelcome to Course Registration System\n");
				System.out.println("Login Date and Time: " + localDateTime + "\n");
				System.out.println("----------------------------------------------------------------");
				System.out.println(
						"\nEnter your selection:\n\n\t\t1 View Enrolled Students \n\t\t2 Assign Grades \n\t\t0 Log Out");
				System.out.println("----------------------------------------------------------------");
				int option = in.nextInt();

				switch (option) {
				case 1:
					System.out.println("Enter the courseId to view the enrolled students:");
					String courseId = in.next();
					try {
						psi.viewEnrolledStudents(courseId);
					} catch (EnrolledStudentsException e1) {
						e1.getMessage();
					}
					break;
				case 2:

					System.out.println("\nList of Courses Available");
					List<Course> courseList = abo.fetchCourse();

					fmt.format("%15s %15s %18s\n", "Course Name", "Course Id", "No. of Students");

					courseList.forEach(c -> {

						fmt.format("%14s %14s %17s\n", c.getName() + "|", c.getId() + "|", c.getNoOfStudents());

					});
					System.out.println(fmt);

					System.out.println("\nPlease Enter a Course Id to view the enrolled students in the course");
					String course = in.next();

					try {
						psi.viewEnrolledStudents(course);
					} catch (EnrolledStudentsException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}

					System.out.println("\nPlease Enter a StudentId to Enter Grade");
					String studentId = in.next();
					System.out.println("\nPlease Enter a Grade to the student");
					String grade = in.next().toUpperCase();

					try {
						psi.addGrades(course, studentId, grade);
					} catch (AddGradesException e) {
						e.getMessage();
					}

					// call respective method
					break;

				default:
					return;
				// call respective method for invalid input;
				}

			}
		}
	}

	public static Professor loginProfessor(String userName, String password) throws InvalidCredentailsException {

		LoginDaoImpl ldi = new LoginDaoImpl();
		Professor professor = ldi.isProfessorAuthenticated(userName, password);
		ldi.closeConnection();
		if (professor != null)
			return professor;
		else
			throw new InvalidCredentailsException("Invalid username/password");

	}
}
