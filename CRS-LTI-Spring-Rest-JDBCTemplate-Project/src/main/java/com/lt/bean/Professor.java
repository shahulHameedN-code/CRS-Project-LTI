package com.lt.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * Bean ofprofessor to store the professor details
 */

@Entity
@Table
public class Professor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String id;
	@Column
	private String name;
	@OneToMany(mappedBy = "professor")
	private List<Course> courseList;

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

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}
