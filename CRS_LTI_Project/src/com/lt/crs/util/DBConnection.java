package com.lt.crs.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * @author Shahul
 * 
 * 
 */

/**
 * The class DB connection
 */
public class DBConnection {

	/*
	 * // Step 1 // JDBC driver name and database URL static final String
	 * JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; static final String DB_URL =
	 * "jdbc:mysql://localhost:3306/crs_lti_project?useSSL=false";
	 * 
	 * // Database credentials static final String USER = "root"; static final
	 * String PASS = "shahul1999root";
	 */

	/**
	 *
	 * Gets the DB connection
	 *
	 * @return the DB connection
	 */
	static Properties prop = null;
	static String driver = "";
	static String DB_URL = "";
	static String USER = "";
	static String PASS = "";

	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			if (prop == null) {
				FileReader reader = new FileReader(
						"D:\\javaCoding\\LTI-CRS-Integration-22122021\\CRSProject\\config.properties");

				prop = new Properties();
				prop.load(reader);

				driver = prop.getProperty("driver");
				DB_URL = prop.getProperty("url");
				USER = prop.getProperty("user");
				PASS = prop.getProperty("password");
				Class.forName(driver);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
			} else {

				Class.forName(driver);
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
