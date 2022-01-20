package com.lt.Admin.beans;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@Column
	private String studentId;

	@Column
	private String name;

	@OneToMany(mappedBy = "student", cascade = { CascadeType.PERSIST, CascadeType.REMOVE })

	private Set<StudentCourse> studentCourse = new HashSet<>();

	@Column
	private String address;

	@Column
	private String emailId;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Set<StudentCourse> getStudentCourse() {
		return studentCourse;
	}

	public void setStudentCourse(Set<StudentCourse> studentCourse) {
		this.studentCourse = studentCourse;
	}

	public void addStudentCourse(StudentCourse sc) {
		studentCourse.add(sc);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", studentCourse=" + studentCourse + "]";
	}

}
