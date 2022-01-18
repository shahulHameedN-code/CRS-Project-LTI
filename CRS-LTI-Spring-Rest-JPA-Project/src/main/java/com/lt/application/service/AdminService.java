/**
 * 
 */
package com.lt.application.service;

import com.lt.application.exception.CourseNotFoundException;

/**
 * @author Jeaswanth
 *
 */
public interface AdminService {

	public String removeCourse(String courseId)throws CourseNotFoundException;
}
