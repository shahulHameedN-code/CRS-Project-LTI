package com.lt.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.Student;
/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * 
 * JdbcTemplate for mapping rows of a ResultSet on a per-row basis.
 * 
 * Implementations of this row mapper perform the actual work of mapping each row to a result object.
 */
public class StudentRowMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student s = new Student();
		s.setName(rs.getString("name"));
		s.setId(rs.getString("id"));
		// TODO Auto-generated method stub
		return s;
	}

}
