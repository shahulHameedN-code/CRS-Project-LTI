package com.lt.crs.intrfc;

import java.util.List;

import com.lt.crs.bean.Professor;
import com.lt.crs.bean.Student;
import com.lt.crs.exception.AddProfessorException;

public interface ProfessorDao {

	public void closeConnection();

	public void saveProfessor(Professor p) throws AddProfessorException;

	public List<Student> viewEnrolledStudents(String courseId);

	public void addGrades(String grade, String studentId, String courseId);

}
