/**
 * 
 */
package com.lt.Admin.service;

import com.lt.Admin.exception.CourseNotFoundException;

/**
 * @author Jeaswanth
 *
 */
public interface AdminService {

	public String removeCourse(String courseId)throws CourseNotFoundException;
}
