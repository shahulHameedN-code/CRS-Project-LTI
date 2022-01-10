package com.lt.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

import com.lt.bean.Course;
import com.lt.bean.Student;

/**
 * @author Shahul
 *
 */

@Configuration
public class StudentRepository {

	private static List<Student> studentList = new ArrayList<>();

	private List<Student> student = new ArrayList<>();
	private List<Course> courseListSha = new ArrayList<>();
	private List<Course> courseList = new ArrayList<>();

	public String removeCourse(String studentId, String courseId) {

		student.stream().filter(s -> s.getId().equalsIgnoreCase(studentId)).map(s -> s.getCourseList())
				.forEach(c -> c.removeIf(co -> co.getId().equalsIgnoreCase(courseId)));

		System.out.println(student);

		return "Course Removed from student";

	}

	public List<String> viewGrades(String studentId) {

		List<String> gradeList = new ArrayList<>();

		for (Student student : student) {

			if (student.getId().equals(studentId)) {
				gradeList.add(student.getGrade());
				return gradeList;
			}

		}
		return null;
	}

	public static String addgrades(String studentId, String courseId, String grade) {
		for (Student student : studentList) {
			if (student.getId().equalsIgnoreCase(studentId)) {
				student.setGrade(grade);
				return "Grade was assigned for the student successfully!";
			}
		}

		return null;
	}

	static {

		studentList.add(new Student("shraddha", "100", "A"));
		studentList.add(new Student("shahul", "200", "A"));
		studentList.add(new Student("shital", "300", "A++"));
	}

	@PostConstruct
	public void addStudentCourse() {
		courseList.add(new Course("JAVA", "111"));
		courseList.add(new Course("JAVA", "222"));
		courseListSha.add(new Course("JAVA", "111"));
		courseListSha.add(new Course("JAVA", "222"));
		student.add(new Student("shraddha", "100", "A", courseListSha));
		student.add(new Student("shahul", "200", "A", courseList));
		student.add(new Student("shital", "300", "A++", courseList));

	}

}
