package com.lt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.repository.CourseRepository;

@Service
public class CourseServiceImpl {
	@Autowired
	CourseRepository courseRepository;
	public List<Course> viewCourses() {
		return courseRepository.viewCourseList();
	}
}
