package com.lt.crs.bean;

import java.util.List;

/**
 * @author Jeaswanth 
 * Professor details
 */

public class Professor {

	private String name;
	private String id;
	private String address;
	private Department department;
	private List<Course> courseList;

	public Professor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * constructor
	 *
	 */

	public Professor() {
	}

	/**
	 * Overridden toString() method
	 *
	 */
	@Override
	public String toString() {
		return "Professor [name=" + name + ", id=" + id + "]";
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param professorName         : name
	 * @param professorId:          id
	 * @param professorAddress:     Address
	 * @param courseList:courseList
	 */

	public Professor(String name, String id, String address, List<Course> courseList) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.courseList = courseList;
	}

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
	 * Method to get profId
	 * 
	 * @return Id
	 */

	public String getId() {
		return id;
	}

	/**
	 * Method to set profId
	 * 
	 * @param Id
	 */

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Method to get profAddress
	 * 
	 * @return Address
	 */

	public String getAddress() {
		return address;
	}

	/**
	 * Method to set profId
	 * 
	 * @param address
	 */

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Method to get Department
	 * 
	 * @return department
	 */

	public Department getDepartment() {
		return department;
	}

	/**
	 * Method to set Department
	 * 
	 * @param department
	 */

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * Method to get List Of course
	 * 
	 * @return courseList
	 */
	public List<Course> getCourseList() {
		return courseList;
	}

	/**
	 * Method to set List Of course
	 * 
	 * @param courseList
	 */

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}
