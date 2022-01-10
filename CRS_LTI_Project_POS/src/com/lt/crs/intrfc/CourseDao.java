package com.lt.crs.intrfc;

import java.sql.SQLException;
import java.util.List;

import com.lt.crs.bean.Course;

public interface CourseDao {

	public void closeConnection();

	public void addCourse(Course course);

	public List<Course> fetchCourse();

	public void removeCourse(String courseId);

	public Course fetchCourse(Course course) throws ClassNotFoundException, SQLException;

}
