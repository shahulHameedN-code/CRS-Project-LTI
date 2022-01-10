/**
 * 
 */
package com.lt.service;

import com.lt.exception.CourseNotFoundException;

/**
 * @author Jeaswanth
 *
 */
public interface AdminService {

	public String removeCourse(String courseId)throws CourseNotFoundException;
}
