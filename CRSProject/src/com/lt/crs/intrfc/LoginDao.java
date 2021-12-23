package com.lt.crs.intrfc;

public interface LoginDao {

	public boolean isAuthenticated(String username, String password);

	public void closeConnection();

}
