package com.lt.crs.business;

import java.util.ArrayList;
import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Department;
import com.lt.crs.bean.Student;
import com.lt.crs.intrfc.ReportCard;

public class ReportCardService implements ReportCard {
	
	public void generateReportCard() {
		System.out.println("Welcome students Report Card");
		System.out.println();
		System.out.println();

		for(Student s  : studentDataDump()) {
			System.out.println("------------------------------students Report Card ---------------------------------");
			System.out.println("Student Name     ----> "+ s.getName());
			System.out.println("Student Id       ----> "+ s.getId());
			System.out.println("Department Name  ----> "+ s.getDepartment().getName());
			System.out.println("courses enrolled and grades ");
			
			for(Course c:s.getCourseList()) {
				System.out.println("------------------------------------------");
			System.out.println("course name      ----> "+c.getName());
			System.out.println("course id        ----> "+c.getId());
			System.out.println("course grade     ----> "+c.getGrade());
			
			System.out.println("------------------------------------------");
			}
			
			System.out.println("---------------------------------------------------------------");
		}
		
	}
	
	private List<Student>studentDataDump(){
		List<Student>studentList=new ArrayList<Student>();
		Student s=new Student();
		s.setName("Shahul");
		s.setId("10695551");
		Department d=new Department();
		d.setId("CS - 101");
		d.setName("CS");
		s.setDepartment(d);
		List<Course>courseList=new ArrayList<>();
		Course course=new Course();
		course.setId("course - 101 ");
		course.setName("JAVA");
		course.setGrade("80");
		Course course1=new Course();
		course1.setId("course - 102 ");
		course1.setName("Python");
		course1.setGrade("70");
		courseList.add(course);
		courseList.add(course1);
		s.setCourseList(courseList);
		
		studentList.add(s);
		

		Student s1=new Student();
		s1.setName("Hameed");
		s1.setId("10695552");
		Department d1=new Department();
		d1.setId("CS - 102");
		d1.setName("CS-II");
		s1.setDepartment(d);
		List<Course>courseList1=new ArrayList<>();
		Course course2=new Course();
		course1.setId("course - 103 ");
		course2.setName("Advanced JAVA");
		course2.setGrade("8");
		Course course3=new Course();
		course3.setId("course - 104 ");
		course3.setName("Advanced Python");
		course3.setGrade("75");
		courseList1.add(course2);
		courseList1.add(course3);
		s1.setCourseList(courseList1);
		
		
		
		
		studentList.add(s1);
		
		
		
		
		return studentList;
	}

}
