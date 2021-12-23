package com.lt.crs.menu;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Payment;
import com.lt.crs.bean.Student;
import com.lt.crs.business.AdminBusinessOperation;
import com.lt.crs.business.PaymentServiceImpl;
import com.lt.crs.business.StudentServiceImpl;
import com.lt.crs.dao.LoginDaoImpl;
import com.lt.crs.exception.InvalidCredentailsException;
import com.lt.crs.exception.RemoveCourseException;
import com.lt.crs.intrfc.Menu;

/**
 * 
 * @author Bhuvaneshwari
 * 
 * 
 */
public class StudentMenu implements Menu {

	@Override
	public void menu() {

		StudentServiceImpl ssi = new StudentServiceImpl();
		AdminBusinessOperation abo = new AdminBusinessOperation();
		PaymentServiceImpl psi = new PaymentServiceImpl();
		Random r = new Random();
		String userName = "";
		String password = "";
		Student student = null;
		Scanner in = new Scanner(System.in);
		boolean login = false;
		while (true) {
			final Formatter fmt = new Formatter();
			if (student == null) {
				System.out.println("\n\n~~~~~~ Welcome to Course Registration System - Student Page ~~~~~~");
				System.out.println("----------------------------------------------------------------");
				System.out.println("\t\tPlease login to continue");
				System.out.println("UserName:");
				userName = in.next();
				System.out.println("Password:");
				password = in.next();
				try {
					student = loginStudent(userName, password);
				} catch (InvalidCredentailsException e) {
					// TODO Auto-generated catch block

					System.out.println(e.getMessage());
				}
			}

			if (student != null) {
				System.out.println("----------------------------------------------------------------");
				LocalDateTime localDateTime = LocalDateTime.now();
				System.out.println(
						"Hi " + student.getName().toUpperCase() + ",\n\tWelcome to Course Registration System\n");
				System.out.println("Login Date and Time: " + localDateTime + "\n");
				System.out.println("----------------------------------------------------------------");
				System.out.println(
						"\nEnter your selection:\n\t\t1 Add Course \n\t\t2 Drop Course \n\t\t3 View Grades \n\t\t4 Payment \n\t\t0 Log Out");
				System.out.println("----------------------------------------------------------------");
				int option = in.nextInt();

				switch (option) {
				case 1:

					abo.fetchCourse().forEach(co -> {

						System.out.println("----------------Course Details----------------");
						System.out.println("Course Name    ----> " + co.getName());
						System.out.println("Course Id      ----> " + co.getId());
						System.out.println("No of Students ----> " + co.getNoOfStudents());
						System.out.println("----------------------------------------------\n");

					});

					String courseId = "";
					System.out.println("Studentid -----------> " + student.getId());
					List<Course> courseList = new ArrayList<Course>();
					int i = 0;
					System.out.println("You need to Enroll in 6 courses \n");
					System.out.println("Enter you course Id one by one \n");
					while (true) {
						System.out.println("Enter Course Id to enroll");
						courseId = in.next();
						Course c = new Course();
						c.setId(courseId);
						courseList.add(c);
						i++;
						if (i == 6) {
							System.out.println("you have selected maximum number of courses ");
							break;
						}
						System.out.println("Would you like to Add course [y/n] ? \n");
						String ch = in.next();

						if (ch.equalsIgnoreCase("N"))
							break;

					}

					System.out.println("Course Id's Selected \n");

					courseList.forEach(c -> {
						System.out.println("Course Id -------------> " + c.getId() + "\n");

					});

					ssi.addCourse(courseList, student.getId());

					break;

				// add course

				case 2:
					// Drop course

					List<Course> course = ssi.viewEnrolledCourses(student.getId());
					System.out.println("----------------------------------------------------------------");

					fmt.format("%15s %15s\n", "Course Id", "Course Name");

					course.forEach(c -> {

						fmt.format("%14s %14s \n", c.getId() + "|", c.getName());

					});
					System.out.println(fmt);

					System.out.println("----------------------------------------------------------------");
					System.out.println("Enter the course Id to be Dropped:");
					String course_id = in.next();
					try {
						ssi.dropCourse(student.getId(), course_id);
					} catch (RemoveCourseException e) {
						e.getMessage();
					}
					System.out.println("Course with " + course_id + " was dropped");

					break;
				case 3:

					Student studentGrades = ssi.viewGrades(student.getId());
					System.out.println("Student Name -----------> " + student.getName() + "\n");
					System.out.println("Student Id -------------> " + student.getId() + "\n");
					System.out.println("Courses and Grades \n");

					fmt.format("%15s %15s %15s\n", "Course Name", "Course Id", "Grade");

					studentGrades.getCourseList().forEach(c -> {

						fmt.format("%14s %14s %17s\n", c.getName() + "|", c.getId() + "|", c.getGrade());

					});
					System.out.println(fmt);

					// view grades

					break;
				case 4:
					// payment
					try {
						System.out.println("\n\n~~~~~~ Welcome to Payment Gateway  ~~~~~~");
						System.out.println("----------------------------------------------------------------");

						int totalAmount = ssi.viewTotalAmount(student.getId());

						System.out.println("Total Amount to be Paid " + totalAmount);
						System.out.println("Confirm if you want to proceed for Payment [y/n]");

						String ch = in.next();
						if (ch.equalsIgnoreCase("n"))
							break;

						System.out.println("\t\tPlease enter below details");
						System.out.println("Card number:");
						String cardNumber = in.next();
						System.out.println("CVV number:");
						String cvvNumber = in.next();
						System.out.println("Expiry date in mm-yyyy format");
						String expiryDate = in.next();

						Payment payment = new Payment();
						payment.setStudentId(student.getId());
						payment.setPaymentId(r.nextInt(99999999) + "");
						payment.setTotalAmount(totalAmount);

						System.out.println("Confirm if you want to proceed for Payment [y/n]");

						ch = in.next();
						if (ch.equalsIgnoreCase("n"))
							break;

						psi.makePayment(payment);

						System.out.println("Payment of Rupees " + totalAmount + " is Successful");

					} catch (Exception e) {
						// TODO Auto-generated catch block

						System.out.println(e.getMessage());
					}

					break;

				default:
					return;
				// call respective method for invalid input;
				}

			}
		}
	}

	public static Student loginStudent(String userName, String password) throws InvalidCredentailsException {

		LoginDaoImpl ldi = new LoginDaoImpl();
		Student s = ldi.isAuthenticatedStudent(userName, password);
		ldi.closeConnection();
		if (s != null)
			return s;
		else
			throw new InvalidCredentailsException("Invalid username/password or not approved by admin");

	}

}
