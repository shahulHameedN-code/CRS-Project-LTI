package com.lt.crs.bean;

import java.util.List;

/**
 * @author shahul
 *  Department Details
 */

public class Department {

	private String name;
	private String id;
	private List<Course> courseList;

	/**
	 * Method to get name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to get id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Method to set id
	 * 
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get CourseList
	 * 
	 * @return CourseList
	 */
	public List<Course> getCourseList() {
		return courseList;
	}

	/**
	 * Method to set CourseList
	 * 
	 * @param CourseList
	 */
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	/**
	 * toString() method
	 * 
	 * @return string
	 */

	@Override
	public String toString() {
		return "Department [name=" + name + ", id=" + id + ", courseList=" + courseList + "]";
	}

}
