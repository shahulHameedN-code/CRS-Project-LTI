package com.lt.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lt.bean.Course;
import com.lt.constant.SQLConstant;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * @Bean Course class methods we are initiliz here. define instantiation,
 *       configuration, and initialization logic for objects.
 * 
 */

@Repository
public class CourseRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Course> viewCourseList() {
		return jdbcTemplate.query(SQLConstant.VIEW_LIST_COURSES, new RowMapper<Course>() {
			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course c = new Course();
				c.setId(rs.getString("course_id"));
				c.setName(rs.getString("course_name"));
				c.setNoOfStudents(rs.getInt("noOfStudents"));
				c.setPaymentFee(rs.getInt("paymentFee"));
				return c;
			}
		});

	}
}
