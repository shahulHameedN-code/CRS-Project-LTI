package com.lt.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital
 * @Bean of Course to store the Course details
 */
@Entity
@Table
public class Course {
	@Column
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private String id;
	@Column
	private String grade;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Student> listStudent;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Professor professor;
	private int noOfStudents;
	private int paymentFee;

	public Course() {
	}

	public Course(String name, String id, String grade, List<Student> listStudent) {
		super();
		this.name = name;
		this.id = id;
		this.grade = grade;
		this.listStudent = listStudent;
//		this.professor = professor;
	}

	public Course(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

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

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public int getPaymentFee() {
		return paymentFee;
	}

	public void setPaymentFee(int paymentFee) {
		this.paymentFee = paymentFee;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", id=" + id + ", grade=" + grade + ", listStudent=" + listStudent
				+ ", professor=" + professor + "]";
	}

}
