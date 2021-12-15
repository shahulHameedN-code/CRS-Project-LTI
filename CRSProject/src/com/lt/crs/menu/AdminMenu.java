package com.lt.crs.menu;

import java.util.Scanner;

import com.lt.crs.business.AdminBusinessOpertion;
import com.lt.crs.business.ReportCardService;
import com.lt.crs.intrfc.Menu;
import com.lt.crs.intrfc.ReportCard;

public class AdminMenu implements Menu {

	public void menu() {
		while (true) {

			System.out.println("Welcome to Course Registration System -  Admin Page");
			Scanner in = new Scanner(System.in);
			System.out.println("Please login to continue");
			System.out.println("Enter userName");
			String userName = in.nextLine();
			System.out.println("Enter password");
			String password = in.nextLine();

			if (loginAdmin(userName,password)) {

				System.out.println(
						"Enter your selection:\n1  Add course\n2  remove course \n3 generate report card \n4 Add professor \n5 Approve student registration\nExit: Any other input");

				int option = in.nextInt();
				AdminBusinessOpertion abo = new AdminBusinessOpertion();
				switch (option) {
				case 1:

					abo.SaveCourse();
					// call respective method
					break;
				case 2:
					// call respective method
					break;
				case 3:
					// call respective method
					ReportCard rc = new ReportCardService();
					rc.generateReportCard();
					break;
				case 4:
					abo.saveProfessor();
					break;
				default:
					return;
				// call respective method for invalid input;
				}

			}
		}
	}

	public static boolean loginAdmin(String userName, String password) {

		if (userName == "admin" && password == "admin")
			return true;

		return false;

	}

}
