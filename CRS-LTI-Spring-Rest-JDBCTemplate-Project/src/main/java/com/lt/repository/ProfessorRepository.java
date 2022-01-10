package com.lt.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lt.bean.Student;
import com.lt.constant.SQLConstant;
import com.lt.rowmapper.StudentRowMapper;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital that an @Repository
 *         annotated class is a “Repository”,
 * @Bean Professor class methods we are initiliz here. define instantiation,
 *       configuration, and initialization logic for objects.
 * 
 */

@Repository
public class ProfessorRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/* here we are return the studentList */
	public List<Student> viewEnrolledStudents(String courseId) {

		List<Student> studentList = jdbcTemplate.query(SQLConstant.VIEW_ENROLLED_STUDENT, new Object[] { courseId },
				new StudentRowMapper());
		return studentList;
	}

	/* here using addgrade method we are adding the grade */
	public int addgrades(String studentId, String courseId, String grade) {

		int row=jdbcTemplate.update(SQLConstant.ADD_GRADES, grade, studentId, courseId);
		return row;
	}

}
