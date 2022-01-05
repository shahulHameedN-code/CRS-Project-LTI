package com.lt.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Column
	private String name;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	public Student(String name, String id, String grade) {
		super();
		this.name = name;
		this.id = id;
		this.grade = grade;
	}

	public Student(String name, String id, String grade, List<Course> courseList) {
		super();
		this.name = name;
		this.id = id;
		this.courseList = courseList;
		this.grade = grade;
	}

	@OneToMany(mappedBy = "student")
	private List<Course> courseList;
	@Column
	private String grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
		return "Student [name=" + name + ", id=" + id + ", courseList=" + courseList + ", grade=" + grade + "]";
	}

}
