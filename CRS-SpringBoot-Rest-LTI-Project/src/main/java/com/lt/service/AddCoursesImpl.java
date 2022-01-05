/**
 * 
 */
package com.lt.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.intrfc.AddCourses;

/**
 * @author Jeaswanth
 *
 */
@Service
public class AddCoursesImpl implements AddCourses {

	List<Student> students = new ArrayList<>();
	List<Course> courseList = new ArrayList<>();

	@Override
	public String addCourses(String courses) {
		JSONObject jsonObj = new JSONObject(courses);

		jsonObj.getString("studentId");
		jsonObj.getString("studentName");
		JSONArray jsa = jsonObj.getJSONArray("courseList");

		for (Student student : studentsData()) {
			if (student.getId().equals(jsonObj.get("studentId"))) {
				List<Course> course = new ArrayList<Course>();
				for (int i = 0; i < jsa.length(); i++) {

					JSONObject jso = jsa.getJSONObject(i);
					Course c = new Course(jso.getString("courseName"), jso.getString("courseId"));
					course.add(c);
				}

				student.setCourseList(course);
			}
		}
		return "Courses were added successfully for the student";
	}

	private List<Student> studentsData() {
		students.add(new Student("shraddha", "100", "A", courseList));
		students.add(new Student("shahul", "200", "A", courseList));
		students.add(new Student("shital", "300", "A++", courseList));
		return students;
	}

}
