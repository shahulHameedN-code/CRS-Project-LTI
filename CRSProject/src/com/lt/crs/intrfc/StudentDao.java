package com.lt.crs.intrfc;

import java.util.List;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.exception.RemoveCourseException;

public interface StudentDao {

	public void dropCourse(String studentId, String courseId) throws RemoveCourseException;

	public List<Course> viewEnrolledCourses(String studentId);

	public void addCourse(List<Course> courseList, String studentId);

	Student viewGrade(String studentId);

}
