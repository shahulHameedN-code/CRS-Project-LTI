/**
 * 
 */
package com.lt.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Course;

/**
 * @author Jeaswanth
 *
 */
public class StudentGradeRowMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

		Course c = new Course();
		c.setId(rs.getString("course_id"));
		c.setName(rs.getString("course_name"));
		c.setGrade(rs.getString("grade"));

		return c;
	}

}
