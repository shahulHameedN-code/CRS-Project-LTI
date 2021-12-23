package com.lt.crs.menu;

import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Department;
import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.business.AdminBusinessOperation;
import com.lt.crs.business.ReportCardService;
import com.lt.crs.dao.LoginDaoImpl;
import com.lt.crs.exception.AddProfessorException;
import com.lt.crs.exception.InvalidCredentailsException;
import com.lt.crs.exception.RemoveCourseException;
import com.lt.crs.exception.ReportCardException;
import com.lt.crs.exception.SaveCourseException;
import com.lt.crs.exception.UserNotApprovedException;
import com.lt.crs.intrfc.Menu;
import com.lt.crs.intrfc.ReportCard;

/**
 * 
 * @author Shahul
 * 
 * 
 */

/**
 * The class Admin menu implements menu
 */
public class AdminMenu implements Menu {

	public void menu() {
		final Formatter fmt = new Formatter();
		AdminBusinessOperation abo = new AdminBusinessOperation();
		String userName = "";
		String password = "";
		Scanner in = new Scanner(System.in);
		boolean login = false;
		while (true) {

			if (!login) {
				System.out.println("\n\n~~~~~~ Welcome to Course Registration System - Admin Page ~~~~~~");
				System.out.println("----------------------------------------------------------------");
				System.out.println("\t\tPlease login to continue");
				System.out.println("UserName:");
				userName = in.next();
				System.out.println("Password:");
				password = in.next();
				try {
					login = loginAdmin(userName, password);
				} catch (InvalidCredentailsException e) {
					System.out.println(e.getMessage());
				}
			}

			if (login) {
				System.out.println("----------------------------------------------------------------");
				LocalDateTime localDateTime = LocalDateTime.now();
				System.out.println("Hi ADMIN,\n\tWelcome to Course Registration System\n");
				System.out.println("Login Date and Time: " + localDateTime + "\n");
				System.out.println("----------------------------------------------------------------");
				System.out.println(
						"\nEnter your selection:\n\n\t\t1 Add course\n\t\t2 Remove course \n\t\t3 Generate report card \n\t\t4 Add professor \n\t\t5 Approve student registration \n\t\t6 Fetch Course Details \n\t\t7 Fetch Professor Details \n\t\t0 Log Out");
				System.out.println("----------------------------------------------------------------");
				int option = in.nextInt();

				switch (option) {
				case 1:
					System.out.println("\nPlease enter the required detalis for addition of new Course:");
					System.out.println("-------------------------------------------------------------");
					System.out.println("Enter the name of the Course to be added:");
					String courseName = in.next();
					System.out.println("Enter course Id:");
					String courseId = in.next();
					System.out.println("No. of students that can enroll:");
					int stuCount = in.nextInt();
					Course c = new Course(courseName, courseId, stuCount);
					try {
						abo.SaveCourse(c);
					} catch (SaveCourseException e1) {
						// TODO Auto-generated catch block
						e1.getMessage();
					}
					break;
				case 2:

					try {
						abo.removeCourse();
					} catch (RemoveCourseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					// call respective method
					break;
				case 3:
					// call respective method
					ReportCard rc = new ReportCardService();
					try {
						rc.generateReportCard();
					} catch (ReportCardException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("\nPlease enter the required details for addition of Professor");
					System.out.println("-----------------------------------------------------------");
					System.out.println("Enter Professor Name:");
					String professorName = in.next();
					System.out.println("Enter ProfessorId:");
					String professorId = in.next();
					System.out.println("Enter Professor DepartmentId:");
					String departmentId = in.next();
					Professor p = new Professor();
					p.setName(professorName);
					p.setId(professorId);
					Department d = new Department();
					d.setId(departmentId);
					p.setDepartment(d);
					try {
						abo.saveProfessor(p);
					} catch (AddProfessorException e) {
						System.out.println(e.getMessage());

					}
					break;
				case 5:

					boolean continuation = true;
					while (continuation) {
						List<Student> studentList = abo.getPendingApprovalStudents();

						fmt.format("%15s %15s \n", "Student Name", "Student Id");

						studentList.forEach(s -> {

							fmt.format("%14s %14s \n", s.getName() + "|", s.getId());

						});
						System.out.println(fmt);

						System.out.println("Enter the Student Id that has to Approved OR Press E to Exit");
						String studentId = in.next();

						if (studentId.equalsIgnoreCase("e"))
							continuation = false;
						else {

							Student s = new Student();
							s.setId(studentId);
							try {
								abo.approveRegisteredStudents(s);
								System.out.println("Selected Student is Approved");
							} catch (UserNotApprovedException e) {
								e.getMessage();
							}

						}

					}
					break;
				case 6:
					List<Course> courseList = abo.fetchCourse();
					System.out.println("----------------Course Details----------------\n");
					fmt.format("%15s %15s %19s\n", "Course Name", "Course Id", "No. of students");

					courseList.forEach(co -> {

						fmt.format("%14s %14s %17s\n", co.getName() + "|", co.getId() + "|", co.getNoOfStudents());

					});

					System.out.println(fmt);

					break;
				case 7:
					System.out.println("----------------Professor Details----------------");
					List<Professor> professorList = abo.fetchProfessor();

					fmt.format("%15s %15s \n", "Professor Name", "Professor Id");

					professorList.forEach(po -> {

						fmt.format("%14s %14s \n", po.getName() + "|", po.getId());

					});

					System.out.println(fmt);

					System.out.println("-------------------------------------------------\n");
					break;

				default:
					return;
				// call respective method for invalid input;
				}

			}
		}
	}

	public static boolean loginAdmin(String userName, String password) throws InvalidCredentailsException {

		LoginDaoImpl ldi = new LoginDaoImpl();
		boolean bool = ldi.isAuthenticated(userName, password);
		ldi.closeConnection();

		if (bool)
			return bool;
		else
			throw new InvalidCredentailsException("Invalid username/password");

	}
}
