package com.lt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.bean.Course;
import com.lt.exception.CourseNotFoundException;
import com.lt.service.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseRestController {

	@Autowired
	CourseServiceImpl courseServiceImpl;

	@RequestMapping(path = "/viewCourses", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Course>> viewAvailableCourses() throws CourseNotFoundException {

		List<Course> course = courseServiceImpl.viewCourses();
		if (course == null)
			throw new CourseNotFoundException();

		return ResponseEntity.ok().body(course);
	}
}
