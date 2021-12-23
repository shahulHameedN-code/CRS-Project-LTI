package com.lt.crs.business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Professor;

public class AdminBusinessOpertion {
	Course [] addcourse = new Course[3];
	Professor[] addprofessor = new Professor[3];
	public void SaveCourse() {
		
		/*
		 * addcourse[0].setId("456"); addcourse[0].setName("ECE");
		 * addcourse[0].setNoOfStudents(4);
		 * 
		 * addcourse[1].setId("457"); addcourse[1].setName("BTECH");
		 * addcourse[1].setNoOfStudents(10);
		 * 
		 * addcourse[2].setId("458"); addcourse[2].setName("BCA");
		 * addcourse[2].setNoOfStudents(3);
		 * 
		 * addcourse[3].setId("459"); addcourse[3].setName("BSC");
		 * addcourse[3].setNoOfStudents(5);;
		 */
		List<Course>addCourse = new ArrayList<>();
		addCourse.add(new Course("ECE", "456", 4));
		addCourse.add(new Course("BTech", "457", 10));
		addCourse.add(new Course("BCA", "458", 3));
		addCourse.add(new Course("BSC", "459", 5));
		
	}

	public void saveProfessor() {
		addprofessor[0].setId("101");
		addprofessor[0].setName("Amit");
		addprofessor[0].setAddress("Delhi");
		for(Course listCourse :addcourse) {
			addprofessor[0].setCourseList(Arrays.asList(listCourse));
		}
		
		addprofessor[0].setDepartment(null);
		
		addprofessor[1].setId("102");
		addprofessor[1].setName("Ram");
		addprofessor[1].setAddress("Chennai");
		for(Course listCourse :addcourse) {
			addprofessor[1].setCourseList(Arrays.asList(listCourse));
		}
		addprofessor[1].setDepartment(null);
		
		addprofessor[2].setId("102");
		addprofessor[2].setName("Raj");
		addprofessor[2].setAddress("Delhi");
		for(Course listCourse :addcourse) {
			addprofessor[2].setCourseList(Arrays.asList(listCourse));
		}
		addprofessor[2].setDepartment(null);
		
		
		
	}
}
