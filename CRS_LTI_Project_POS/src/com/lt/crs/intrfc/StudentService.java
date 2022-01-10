package com.lt.crs.intrfc;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.bean.StudentRegistration;
import com.lt.crs.exception.RemoveCourseException;

public interface StudentService {

	void studentRegisteration(StudentRegistration Register);

	void addCourse(List<Course> courseList, String studentId);

	List<Course> viewEnrolledCourses(String studentId);

	Student viewGrades(String studentId);

	void dropCourse(String studentId, String courseId) throws RemoveCourseException;

}
