package com.lt.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.crs.bean.Course;
import com.lt.crs.bean.Student;
import com.lt.crs.exception.ReportCardException;
import com.lt.crs.intrfc.ReportCard;
import com.lt.crs.intrfc.ReportCardDao;
import com.lt.crs.util.DBConnection;


/**
 * The class ReportCardDaoImpl implements ReportCard
 */ 

/**
 * 
 * @author Shahul
 * 
 * 
 */
public class ReportCardDaoImpl implements ReportCardDao {

	Connection con = null;
	private static Logger log=Logger.getLogger(ReportCardDaoImpl.class);
	
	/** 
	 *
	 * Report card dao impl
	 *
	 * @return 	public
	 */
	public ReportCardDaoImpl() { 

		// TODO Auto-generated constructor stub
		log.debug("Getting DB connection");
		con = DBConnection.getDBConnection();
	}

	@Override

	/** 
	 *
	 * Fetch and generate report
	 *
	 * @return List<Student>
	 */
	public List<Student> fetchAndGenerateReport() { 
		log.debug("Generating the report card for the students on calling FetchAndGenerateReport() method");

		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "select * from student;";
			stmt = con.prepareStatement(sql);

			rs = stmt.executeQuery();
			List<Student> studentList = new ArrayList<Student>();
			while (rs.next()) {
				Student s = new Student();
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				s.setId(rs.getString("id"));
				studentList.add(s);
			}
			stmt.close();
			for (int i = 0; i < studentList.size(); i++) {
				String sql2 = "select * from studentcourse sc inner join course c on c.course_id=sc.course_id where sc.student_id=? ";

				stmt = con.prepareStatement(sql2);
				stmt.setString(1, studentList.get(i).getId());
				rs = stmt.executeQuery();
				List<Course> courseList = new ArrayList<Course>();
				while (rs.next()) {
					Course c = new Course();
					c.setId(rs.getString("course_id"));
					c.setName(rs.getString("course_name"));
					c.setGrade(rs.getString("grade"));
					courseList.add(c);
				}
				studentList.get(i).setCourseList(courseList);
			}

			log.debug("Report cards were generated and list of student objects were returned");
			return studentList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		} finally {
			try {
				stmt.close();
				rs.close();
				log.debug("Closing the DB connection");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
			}
		}

		return null;
	}

	@Override

	/** 
	 *
	 * Close connection
	 *
	 */
	public void closeConnection() { 

		// TODO Auto-generated method stub

		try {
			con.close();
			log.debug("Closing the DB connection");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
		}

	}


}
