package com.lt.application.controller;

/**
 * @author Jeaswanth,shital,shraddha,shahul,sayli,parag.
 * it is the RestController class of CourseRestController it is the used to create RESTful web services
 */
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.repository.CourseRepository.CourseList;
import com.lt.application.service.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseRestController {
	private static Logger log = LoggerFactory.getLogger(CourseRestController.class);

	@Autowired
	CourseServiceImpl courseServiceImpl;

	/**
	 * This is viewCourseList method
	 * 
	 * @param List<Course>
	 * @return Course
	 * @exception SQLException
	 */
	@RequestMapping(path = "/viewCourses", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<CourseList>> viewAvailableCourses() throws CourseNotFoundException {
       log.info("Enterning the viewCourse Details");
		List<CourseList> course = courseServiceImpl.viewCourses();
		if (course == null)
			throw new CourseNotFoundException();
       log.info("Returning the viewCourse");
		return ResponseEntity.ok().body(course);
	}
}
