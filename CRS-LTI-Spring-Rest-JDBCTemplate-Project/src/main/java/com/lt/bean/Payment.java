package com.lt.bean;

/**
 * @author Shraddha,Shahul,Jeaswanth,Parag,Sayli,Shital Bean of payment to store
 *         the payment details
 */

public class Payment {

	int paymentFee;
	int cardNumber;
	int cvvNumber;
	int pin;
	String studentId;
	String courseId;
	String paymentId;

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

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

}
