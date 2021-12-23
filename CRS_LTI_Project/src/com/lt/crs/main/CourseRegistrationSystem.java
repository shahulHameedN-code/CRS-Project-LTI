package com.lt.crs.main;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.lt.crs.bean.StudentRegistration;
import com.lt.crs.business.AdminBusinessOperation;
import com.lt.crs.business.StudentServiceImpl;
import com.lt.crs.dao.LoginDaoImpl;
import com.lt.crs.intrfc.Menu;
import com.lt.crs.menu.AdminMenu;
import com.lt.crs.menu.ProfessorMenu;
import com.lt.crs.menu.StudentMenu;

public class CourseRegistrationSystem {

	public static void main(String[] args) {
		String log4jConfPath = "D:\\javaCoding\\LTI-CRS-Integration-17122021\\CRSProject\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		boolean test = true;
		while (test) {

			System.out.println("-----------------------------------------------------------");
			System.out.println("~~~~~~~~~~ Welcome to Course Registration System ~~~~~~~~~~");
			System.out.println("-----------------------------------------------------------");
			System.out.println("Please Enter the required operation number:");
			System.out.println("\t1. Login");
			System.out.println("\t2. Student Registration");
			System.out.println("\t3. Update Password");
			System.out.println("\t4. Exit");
			Scanner sc = new Scanner(System.in);
			int value = sc.nextInt();
			boolean check = false;
			boolean check1 = false;
			boolean check2 = false;

			if (value == 1) {
				check = true;
			} else if (value == 2) {
				check1 = true;
			} else if (value == 3) {
				check2 = true;
			} else if (value == 4) {
				System.out.println("Closing the application");
				System.exit(1);
			}

			while (check) {

				System.out.println("\nPlease enter the corresponding option to enter the portal");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\t1. Admin Portal");
				System.out.println("\t2. Professor Portal");
				System.out.println("\t3. Student Portal");
				System.out.println("\t0. Home Page");

				Scanner in = new Scanner(System.in);
				int option = in.nextInt();
				AdminBusinessOperation abo = new AdminBusinessOperation();
				Menu menu = null;
				switch (option) {
				case 1:
					menu = new AdminMenu();
					menu.menu();
					break;
				case 2:
					menu = new ProfessorMenu();
					menu.menu();
					break;
				case 3:
					menu = new StudentMenu();
					menu.menu();
					break;
				case 0:
					System.out.println("Redirecting to Home Page\n\n\n");
					check = false;
					break;
				default:
					System.out.println("Invalid input exiting system");
					System.exit(1);
					// call respective method for invalid input;
				}
			}

			while (check1) {
				StudentServiceImpl studentDao = new StudentServiceImpl();
				System.out.println("welcome to student Registeration");
				System.out.println("-------------------------------------------------------------");
				System.out.println("Student Registeration");
				System.out.println("studentId");
				String studentId = sc.next();
				System.out.println("studentName");
				String sudentName = sc.next();
				System.out.println("address");
				String address = sc.next();
				;
				System.out.println("enter the new password");
				String password = sc.next();
				System.out.println("confirm the password");
				String confirmPassword = sc.next();
				if (password.equals(confirmPassword)) {
					String acceptPassword = password;
				} else {
					System.out.println("recorrect the password");
				}

				StudentRegistration registeration = new StudentRegistration();

				registeration.setId(studentId);
				registeration.setName(sudentName);
				registeration.setAddress(address);
				registeration.setPassword(password);

				studentDao.studentRegisteration(registeration);
				check1 = false;

			}

			while (check2) {

				System.out.println("Update Password \n");
				System.out.println("Enter UserId \n");
				String userId = sc.next();
				System.out.println("Enter Current Password");
				String pass = sc.next();
				String newPass = "";
				String conPass = "abc";

				while (!newPass.equals(conPass)) {
					System.out.println("Enter New Password");
					newPass = sc.next();
					System.out.println("Enter Confirm Password");
					conPass = sc.next();
				}
				String acceptPassword = newPass;

				LoginDaoImpl ldi = new LoginDaoImpl();
				int update = ldi.updatePassword(userId, pass, acceptPassword);

				if (update == 1)
					System.out.println("Password Updated");
				else
					System.out.println("Password update failed check userId/currentPassword ");

			}

		}
	}
}
