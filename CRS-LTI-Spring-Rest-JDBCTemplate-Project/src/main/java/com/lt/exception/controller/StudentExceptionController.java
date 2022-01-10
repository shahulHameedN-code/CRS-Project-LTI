package com.lt.exception.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lt.exception.PasswordMismatchException;
import com.lt.exception.PaymentFaildException;
import com.lt.exception.PaymentNotFoundException;
import com.lt.exception.StudentReportCardNotFoundException;
import com.lt.exception.ViewGradeException;

@ControllerAdvice
public class StudentExceptionController {

	@ExceptionHandler(value = PasswordMismatchException.class)
	public ResponseEntity<Object> passwordMismatchException(PasswordMismatchException exception) {

		JSONObject j = new JSONObject();
		j.put("Code", "Error-102");
		j.put("description", "Password and Confirm Password Mismatch");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

	@ExceptionHandler(value = PaymentNotFoundException.class)
	public ResponseEntity<JSONObject> passwordMismatchException(PaymentNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "Error-404");
		j.put("description", "Payment not Found");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

	@ExceptionHandler(value = PaymentFaildException.class)
	public ResponseEntity<JSONObject> paymentFailedException(PaymentFaildException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-105");
		j.put("description", "Payment Failed! ");

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(j);
	}

	@ExceptionHandler(value = ViewGradeException.class)
	public ResponseEntity<JSONObject> viewGradeException(ViewGradeException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-106");
		j.put("description", "Check Student Id ");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

	@ExceptionHandler(value = StudentReportCardNotFoundException.class)
	public ResponseEntity<JSONObject> studentReportNotFoundException(StudentReportCardNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-107");
		j.put("description", "Student Report Card Not Found! Kindly check Student Id ");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

}
