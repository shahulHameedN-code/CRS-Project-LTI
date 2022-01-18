package com.lt.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital Bean ofprofessor to
 *         store the professor details
 */

@Entity
@Table
public class Professor {
	@Id
	@Column
	private String id;
	@Column
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public List<Course> getCourseList() { return courseList; }
	 * 
	 * public void setCourseList(List<Course> courseList) { this.courseList =
	 * courseList; }
	 */

}
