/**
 * 
 */
package com.lt.application.service;

import java.util.List;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.application.entity.Course;
import com.lt.application.entity.Professor;
import com.lt.application.entity.UserLogin;
import com.lt.application.exception.CourseNotFoundException;
import com.lt.application.exception.StudentReportCardNotFoundException;
import com.lt.application.repository.CourseRepository;
import com.lt.application.repository.LoginRepository;
import com.lt.application.repository.ProfessorRepository;
import com.lt.application.repository.StudentCourseRepository;
import com.lt.application.repository.StudentCourseRepository.GenerateReportCard;
import com.lt.application.repository.UserRepository;

/**
 * @author Jeaswanth
 *
 */
@Service
public class AdminServiceImpl implements AdminService {

	private static Logger log = LoggerFactory.getLogger(AdminServiceImpl.class);

	@Autowired
	UserRepository userRepo;

	@Autowired
	ProfessorRepository professorRepo;

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	StudentCourseRepository studentCourseRepo;

	/**
	 * Method to removeCourse from Course Catalog
	 * 
	 * @param courseId
	 * @throws CourseNotFoundException
	 * @return msg
	 */
	public String removeCourse(String courseId) throws CourseNotFoundException {

		log.info("Entering courseId for remove course from admin service");
		courseRepo.deleteById(courseId);
		log.info("Returning removed course from admin service");
		return "course removed successfully!!";
	}

	/**
	 * Method to generate report card
	 * 
	 * @param studentId
	 * @throws studentReportCardNotFound
	 * @return {@link GenerateReportCard}
	 */
	public List<GenerateReportCard> generateReportCard(String studentId) throws StudentReportCardNotFoundException {
		log.info("Entering studentId for generate reportcard from admin service");
		List<GenerateReportCard> card = studentCourseRepo.generateReportCard(studentId);
		if (card == null)
			throw new StudentReportCardNotFoundException();

		log.info("Returning report card from admin service");
		return card;
	}

	/**
	 * Method to addCourse from Course Catalog
	 * 
	 * @param courseId
	 * @param name
	 * @param noOfStudents
	 * @param paymentFee
	 * @return courses
	 */
	public String addCourse(String courseDetails) {

		log.info("Entering course details from admin service");
		JSONObject jsonObj = new JSONObject(courseDetails);
		Course c = new Course();

		c.setCourseId(jsonObj.getString("course_id"));
		c.setCourseName(jsonObj.getString("course_name"));
		c.setNoOfStudents(jsonObj.getInt("noOfStudents"));
		c.setFee(jsonObj.getInt("paymentFee"));

		courseRepo.save(c);

		log.info("Returning course details from admin service");
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

		log.info("Entering professor details from admin service");
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

		log.info("Returning professor from admin service");
		return prof.getName();

		// return professorRepo.saveAll(id,name,password);
	}

	/**
	 * Method to approvedStudent
	 * 
	 * @param userId
	 * @return userId
	 */
	public String approvedStudent(String userId) {

		log.info("Entering userId for approved student from admin service");
		int row = userRepo.approvedStudentByAdmin(userId);

		log.info("Returning approved student from admin service");
		return "Approved Student Succesfully";
	}
}
