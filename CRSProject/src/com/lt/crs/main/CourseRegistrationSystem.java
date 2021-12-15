package com.lt.crs.main;

import java.util.Scanner;

import com.lt.crs.business.AdminBusinessOpertion;
import com.lt.crs.intrfc.Menu;
import com.lt.crs.menu.AdminMenu;
import com.lt.crs.menu.ProfessorMenu;
import com.lt.crs.menu.StudentMenu;

public class CourseRegistrationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {

			System.out.println("Welcome to Course Registration System");

			System.out.println("Press 1 for Admin Portal");
			System.out.println("Press 2 for Professor Portal");
			System.out.println("Press 3 for Student Portal");

			Scanner in = new Scanner(System.in);
			int option = in.nextInt();
			AdminBusinessOpertion abo = new AdminBusinessOpertion();
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

			default:
				System.out.println("invalid input exiting system");
				System.exit(1);
				// call respective method for invalid input;
			}

		}
	}

	
	 
}
