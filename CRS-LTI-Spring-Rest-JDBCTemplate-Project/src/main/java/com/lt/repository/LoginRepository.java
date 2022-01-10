/**
 * 
 */
package com.lt.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lt.bean.UserLogin;
import com.lt.rowmapper.LoginRowMapper;

/**
 * @author Jeaswanth
 *
 */
@Repository
public class LoginRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<UserLogin> userLogin(String userName, String password) {
		String sql =  "select * from user where username=? and password=?";
		List<UserLogin> login =  jdbcTemplate.query(sql,new Object[] {userName,password},new LoginRowMapper());
		return login;
	}
}
