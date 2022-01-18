package com.lt.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.application.repository.CourseRepository;
import com.lt.application.repository.CourseRepository.CourseList;

@Service
public class CourseServiceImpl {

	private static Logger log = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	CourseRepository courseRepository;

	public List<CourseList> viewCourses() {
		log.info("Entering course details from course service");
		List<CourseList> courseList = courseRepository.findCourse();
		for (CourseList c : courseList) {
			System.out.println(c.toString());
		}

		log.info("Returning course details from course service");
		return courseList;
	}
}
