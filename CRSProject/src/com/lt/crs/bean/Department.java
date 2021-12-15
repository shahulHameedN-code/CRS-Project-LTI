package com.lt.crs.bean;

import java.util.List;

public class Department {

	private String name;
	private String id;
	private List<Course>courseList;
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
	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	

	@Override
	public String toString() {
		return "Department [name=" + name + ", id=" + id + ", courseList=" + courseList + "]";
	}
}
