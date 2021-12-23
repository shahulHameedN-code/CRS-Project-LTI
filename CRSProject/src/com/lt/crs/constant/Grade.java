package com.lt.crs.constant;

public enum Grade {
	


	A, B, C, D, E;


	public static Grade getGradesOnString(String grade) {
		grade = grade.toLowerCase();
		switch (grade) {
		case "a":
			return Grade.A;
		case "b":
			return Grade.B;
		case "c":
			return Grade.C;
		case "d":
			return Grade.D;
		default:
			return Grade.E;

		}
	}


}
