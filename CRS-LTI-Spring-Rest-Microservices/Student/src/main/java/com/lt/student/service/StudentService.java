package com.lt.student.service;

import com.lt.student.exception.CourseNotFoundException;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * it is the interface of StudentService
 * and these methods needs to implement in another class
 */
public interface StudentService {
	public String removeCourse(String courseId) throws CourseNotFoundException;
}
