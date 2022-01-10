/**
 * 
 */
package com.lt.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.lt.bean.UserLogin;

/**
 * @author Jeaswanth
 *
 */
public class LoginRowMapper implements RowMapper<UserLogin> {

	@Override
	public UserLogin mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserLogin login = new UserLogin();
		login.setUserName(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		return login;
	}

}
