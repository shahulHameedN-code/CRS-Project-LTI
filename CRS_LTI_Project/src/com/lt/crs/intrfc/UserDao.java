package com.lt.crs.intrfc;

import java.util.List;

import com.lt.crs.bean.Student;

public interface UserDao {

	public List<Student> getPendingApprovalStudents();

	public void approveRegistration(Student student);

	public void closeConnection();

}
