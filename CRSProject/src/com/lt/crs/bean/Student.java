package com.lt.crs.bean;

import java.util.List;

/**
 * 
 * @author Jeaswanth 
 * Student Class
 * 
 */

public class Student {

	private String name;
	private String id;
	private String address;
	private List<Course> courseList;
	private Department department;
	private boolean isApproved;

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
	 * Method to get Id
	 * 
	 * @return Id
	 */

	public String getId() {
		return id;
	}

	/**
	 * Method to set Student Id
	 * 
	 * @param Id
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get Student Address
	 * 
	 * @return Address
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * Method to set Student Address
	 * 
	 * @param Address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method to get CourseList
	 * 
	 * @return courseList
	 */

	public List<Course> getCourseList() {
		return courseList;
	}

	/**
	 * Method to set CourseList
	 * 
	 * @param courseList
	 */
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	/**
	 * Method to get Department
	 * 
	 * @ruturn DeptId
	 */

	public Department getDepartment() {
		return department;
	}

	/**
	 * Method to set Department
	 * 
	 * @param DeptId
	 */

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * toString() method
	 * 
	 */

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", address=" + address + ", courseList=" + courseList
				+ ", department=" + department + "]";
	}

	/**
	 * Method to check approval status of student
	 * 
	 * @return Approval Status
	 */
	public boolean isApproved() {
		return isApproved;
	}

	/**
	 * Method to set approval status of student
	 * 
	 * @return Approval Status
	 */
	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

}
