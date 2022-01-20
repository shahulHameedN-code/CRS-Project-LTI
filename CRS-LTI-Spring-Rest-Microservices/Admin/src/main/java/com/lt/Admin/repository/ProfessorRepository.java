package com.lt.Admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lt.Admin.beans.Professor;


/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital that an @Repository
 *         annotated class is a “Repository”,
 * @Bean Professor class methods we are initiliz here. define instantiation,
 *       configuration, and initialization logic for objects.
 * 
 */

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {

	@Query(value = "select s.student_Id,s.name,s.address,s.email_id from student s inner join student_course sc on s.student_id=sc.student_id where sc.course_id=:courseId", nativeQuery = true)
	List<ViewEnrolledStudentsResponse> viewEnrolledStudents(String courseId);

	public interface ViewEnrolledStudentsResponse {
		String getName();

		String getStudent_Id();

		String getAddress();

		String getEmail_Id();
	}

	@Modifying
	@Transactional
	@Query(value = "update student_course set grade=:grade where student_Id=:studentId and course_id=:courseId ", nativeQuery = true)
	int addgrades(@Param("grade") String grade, @Param("studentId") String studentId,
			@Param("courseId") String courseId);

}
