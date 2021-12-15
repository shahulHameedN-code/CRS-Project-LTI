package com.lt.crs.main;

import java.util.Scanner;

import com.lt.crs.business.AdminBusinessOpertion;
import com.lt.crs.business.ReportCardService;
import com.lt.crs.intrfc.ReportCard;

public class CourseRegistrationSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		while(true) {

		System.out.println("Welcome to Course Registration System");

		// if(loginAdmin()) {
		
		System.out.println(
				"Enter your selection:\n1  Add course\n2  remove course \n3 generate report card \n4 Add professor \n5 Approve student registration\nExit: Any other input");
		
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();
		AdminBusinessOpertion abo=new AdminBusinessOpertion();
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
			ReportCard rc=new ReportCardService();
			rc.generateReportCard();
			break;
		case 4:
			abo.saveProfessor();
			break;
		default:
			// call respective method for invalid input;
		}

	}
	}

	/*
	 * public static boolean loginAdmin() {
	 * 
	 * 
	 * System.out.println("Please enter userid and pwd"); Scanner input = new
	 * Scanner(System.in); int id = input.nextInt(); int pwd = input.nextInt();
	 * 
	 * if(id==123 && pwd==123) return true; else return false;
	 * 
	 * 
	 * return true;
	 * 
	 * }
	 */
}
