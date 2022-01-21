package com.lt.student.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital Bean of payment to store
 *         the payment details
 */

@Entity
@Table
public class Payment {

	@Column
	int paymentFee;
	@Id
	String paymentId;

	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "studentId", referencedColumnName = "studentId")
	Student student;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPaymentFee() {
		return paymentFee;
	}

	public void setPaymentFee(int paymentFee) {
		this.paymentFee = paymentFee;
	}

	@Override
	public String toString() {
		return "Payment [paymentFee=" + paymentFee + ", paymentId=" + paymentId + ", student=" + student + "]";
	}

}
