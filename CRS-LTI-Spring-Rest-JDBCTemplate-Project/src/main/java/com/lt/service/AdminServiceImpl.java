/**
 * 
 */
package com.lt.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.StudentReportCardNotFoundException;
import com.lt.repository.AdminRepository;

/**
 * @author Jeaswanth
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	public String removeCourse(String courseId) throws CourseNotFoundException {
		int row = adminRepo.removeCourse(courseId);
		if (row == 0)
			throw new CourseNotFoundException();

		return "Course Removed Succesfully";
	}

	public JSONObject generateReportCard(String studentId) throws StudentReportCardNotFoundException {
		// TODO Auto-generated method stub

		JSONObject jso = adminRepo.generateReportCard(studentId);
		if (jso == null || jso.isEmpty())
			throw new StudentReportCardNotFoundException();

		return jso;
	}

	public String addCourse(String courseDetails) {
		JSONObject jsonObj = new JSONObject(courseDetails);

		Course course = new Course();
		course.setId(jsonObj.getString("id"));
		course.setName(jsonObj.getString("name"));
		course.setNoOfStudents(jsonObj.getInt("noOfStudents"));
		course.setPaymentFee(jsonObj.getInt("paymentFee"));

		return adminRepo.addCourse(course);
	}

	public String addprofessor(String addProfessorJson) {
		// TODO Auto-generated method stub
		JSONObject jsonObj = new JSONObject(addProfessorJson);

		Professor p = new Professor();
		p.setId(jsonObj.getString("professorId"));
		p.setName(jsonObj.getString("professorName"));

		return adminRepo.addprofessor(p);
	}

}
