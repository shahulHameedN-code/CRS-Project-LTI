package com.lt.crs.bean;

import java.util.Objects;

public class Payment {

	private String paymentId;
	private String studentId;
	private int totalAmount;

	public Payment() {

	}

	public Payment(String paymentId, String studentId, int totalAmount) {
		super();
		this.paymentId = paymentId;
		this.studentId = studentId;
		this.totalAmount = totalAmount;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", studentId=" + studentId + ", totalAmount=" + totalAmount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(paymentId, studentId, totalAmount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(paymentId, other.paymentId) && Objects.equals(studentId, other.studentId)
				&& Objects.equals(totalAmount, other.totalAmount);
	}

}
