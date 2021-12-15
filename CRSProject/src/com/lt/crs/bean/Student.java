package com.lt.crs.bean;

import java.util.List;

public class Student {
	
	private String name;
	private String id;
	private String address;
	private List<Course>courseList;
	private Department department;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", address=" + address + ", courseList=" + courseList
				+ ", department=" + department + "]";
	}
	

}
