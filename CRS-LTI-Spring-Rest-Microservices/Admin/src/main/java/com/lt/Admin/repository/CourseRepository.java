package com.lt.Admin.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.Admin.beans.Course;



/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * @Bean Course class methods we are initiliz here. define instantiation,
 *       configuration, and initialization logic for objects.
 * 
 */

@Repository
public interface CourseRepository extends JpaRepository<Course, String>{
	
	@Modifying
	@Transactional
	@Query(value = "delete from course where course_Id=:courseId", nativeQuery = true)
	int deleteByAdminAndCourseId(@Param("courseId") String courseId);


	
}
