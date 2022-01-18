package com.lt.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lt.application.entity.Course;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * @Bean Course class methods we are initiliz here. define instantiation,
 *       configuration, and initialization logic for objects.
 * 
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

	@Query(value = "select course_id,course_name,fee,no_of_students from course", nativeQuery = true)
	List<CourseList> findCourse();

	public interface CourseList {
		String getCourse_Id();

		String getCourse_Name();

		int getFee();

		int getNo_Of_Students();
	}

}
