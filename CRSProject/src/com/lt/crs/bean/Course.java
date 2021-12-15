package com.lt.crs.bean;

public class Course {
	
	private String name;
	private String id;
	private String grade;
	private int noOfStudents;
	
	
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

	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public int getNoOfStudents() {
		return noOfStudents;
	}
	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}
	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", grade=" + grade + ", noOfStudents=" + noOfStudents + "]";
	}
	
}
