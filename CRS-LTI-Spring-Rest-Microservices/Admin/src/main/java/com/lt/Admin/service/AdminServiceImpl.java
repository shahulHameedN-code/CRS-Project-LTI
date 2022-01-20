/**
 * 
 */
package com.lt.Admin.service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.Admin.beans.Course;
import com.lt.Admin.beans.Professor;
import com.lt.Admin.beans.UserLogin;
import com.lt.Admin.exception.CourseNotFoundException;
import com.lt.Admin.exception.StudentReportCardNotFoundException;
import com.lt.Admin.repository.CourseRepository;
import com.lt.Admin.repository.LoginRepository;
import com.lt.Admin.repository.ProfessorRepository;
import com.lt.Admin.repository.StudentRepository;
import com.lt.Admin.repository.UserRepository;

/**
 * @author Jeaswanth
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	/*
	 * @Autowired AdminRepository adminRepo;
	 */
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	ProfessorRepository professorRepo;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	StudentRepository studentRepo;

	@Autowired
	UserRepository userRepo;
	
	/**
	 * Method to removeCourse from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @return msg
	 */
	public String removeCourse(String courseId) throws CourseNotFoundException {
	
		int row = courseRepo.deleteByAdminAndCourseId(courseId);
		if (row == 0)
			throw new CourseNotFoundException();

		return "Course Removed Succesfully";
	}

	/*
	 * public JSONObject generateReportCard(String studentId) throws
	 * StudentReportCardNotFoundException { // TODO Auto-generated method stub
	 * 
	 * JSONObject jso = adminRepo.generateReportCard(studentId); if (jso == null ||
	 * jso.isEmpty()) throw new StudentReportCardNotFoundException();
	 * 
	 * return jso; }
	 */

	/**
	 * Method to addCourse from Course Catalog
	 * 
	 * @param courseId
	 * @param name
	 * @param noOfStudents
	 * @param paymentFee
	 * @return 
	 * @return courses
	 */
	public String addCourse(String courseDetails) {
		JSONObject jsonObj = new JSONObject(courseDetails);
		Course c = new Course();

		c.setCourseId(jsonObj.getString("course_id"));
		c.setCourseName(jsonObj.getString("course_name"));
		c.setNoOfStudents(jsonObj.getInt("noOfStudents"));
		c.setFee(jsonObj.getInt("paymentFee"));
		
		courseRepo.save(c);
	
		return "Course Added by Admin";
		
	}


	/**
	 * Method to addprofessor
	 * 
	 * @param professorId
	 * @param professorName
	 * @return professor
	 */

	public String addprofessor(String addProfessorJson) {
		// TODO Auto-generated method stub

		JSONObject jsonObj = new JSONObject(addProfessorJson);
		Professor prof = new Professor();
		UserLogin userLogin = new UserLogin();
		
		String professorId = jsonObj.getString("id");
		String professorName = jsonObj.getString("name");
		String password = jsonObj.getString("password");
		
		
		prof.setId(professorId);
		prof.setName(professorName);
	
		userLogin.setPassword(password);
		userLogin.setUserName(jsonObj.getString("name"));
		userLogin.setApproved(false);
		userLogin.setUserId(jsonObj.getString("id"));
		
		
		professorRepo.save(prof);
		loginRepository.save(userLogin);
		
		return prof.getName();

	
         //return professorRepo.saveAll(id,name,password);
	}

	/**
	 * Method to approvedStudent
	 * 
	 * @param userId
	 * @return userId
	 */
	public String approvedStudent(String userId) {


		int row = userRepo.approvedStudentByAdmin(userId);
	
		return "Approved Student Succesfully";
	}
}
