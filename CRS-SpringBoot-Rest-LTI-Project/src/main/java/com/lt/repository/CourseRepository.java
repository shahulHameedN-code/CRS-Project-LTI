package com.lt.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.lt.bean.Course;
import com.lt.bean.Student;




@Configuration
public class CourseRepository {

	private List<Student> student = new ArrayList<>();
	private List<Course> courseList = new ArrayList<>();

	@PostConstruct
	public void addStudentCourse() {

		student.add(new Student("shraddha", "100", "A"));
		student.add(new Student("shahul", "200", "A"));
		student.add(new Student("shital", "300", "A++"));
		courseList.add(new Course("JAVA", "111", "A", student));
		courseList.add(new Course("JAVA", "222", "A", student));
	}

	public List<Student> viewEnrolledStudents(String courseId) {

		List<Student> stuList = courseList.stream().filter(c -> c.getId().equalsIgnoreCase(courseId)).findFirst()
				.map(c -> c.getListStudent()).get();
		return stuList;

	}

}
