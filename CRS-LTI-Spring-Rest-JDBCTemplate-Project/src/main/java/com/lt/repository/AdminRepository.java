/**
 * 
 */
package com.lt.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.lt.bean.Course;
import com.lt.constant.SQLConstant;

/**
 * @author Jeaswanth
 *
 */
@Repository
public class AdminRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * This is removeCourse method
	 * 
	 * @param courseId
	 * @return row
	 */
	public int removeCourse(String courseId) {

		int row = jdbcTemplate.update(SQLConstant.DELETE_COURSE_ADMIN, courseId);
		return row;
	}

	/**
	 * This is removeCourse method
	 * 
	 * @param courseId
	 * @return row
	 */

	public JSONObject generateReportCard(String studentId) {
		String sql = "select * from studentcourse sc inner join course c on c.course_id=sc.course_id inner join student s on s.id=sc.student_id where sc.student_id=?";

		HashMap<String, JSONObject> reportCard = new HashMap<>();
		JSONArray jsa = new JSONArray();
		JSONObject jso = new JSONObject();
		List<JSONObject> report = jdbcTemplate.query(sql, new Object[] { studentId }, new RowMapper<JSONObject>() {

			@Override
			public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException {

				if (reportCard.get(rs.getString("id")) == null) {

					jso.put("studentId", rs.getString("id"));
					jso.put("studentName", rs.getString("name"));

				}
				JSONObject courseObj = new JSONObject();
				courseObj.put("courseId", rs.getString("course_id"));
				courseObj.put("courseName", rs.getString("course_name"));
				courseObj.put("grade", rs.getString("grade"));
				jsa.put(courseObj);

				return null;
			}
		});

		jso.put("courseList", jsa);

		return jso;

	}

	/**
	 * This is addCourse method
	 * 
	 * @param Id
	 * @param name
	 * @param noofstudent
	 * @param PaymentFee
	 * @return student
	 */

	public String addCourse(Course course) {
		jdbcTemplate.update(SQLConstant.ADD_COURSE_DETAILS, course.getId(), course.getName(), course.getNoOfStudents(),
				course.getPaymentFee());

		return "Student " + course.getName() + " added successfully";

	}

	/**
	 * This is addprofessor method
	 * 
	 * @param Id
	 * @param name
	 * @param password
	 * @return message
	 */
	public String addprofessor(String id, String name, String password) {
		// TODO Auto-generated method stub

		jdbcTemplate.update(SQLConstant.ADD_PROFESSOR, id, name);
		jdbcTemplate.update(SQLConstant.REGISTER_USER, name, password, id, true);
		return "Professor added Successfully";

	}

	/**
	 * This is approvedStudent method
	 * 
	 * @param userId
	 * @return message
	 */
	public String approvedStudent(String userId) {
		jdbcTemplate.update(SQLConstant.APPROVED_STUDENT, userId);

		return "Student approved successfully";

	}
}
