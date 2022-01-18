package com.lt.application.exception.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lt.application.constant.CRSConstants;
import com.lt.application.exception.PasswordMismatchException;
import com.lt.application.exception.PaymentFaildException;
import com.lt.application.exception.PaymentNotFoundException;
import com.lt.application.exception.StudentReportCardNotFoundException;
import com.lt.application.exception.ViewGradeException;

@ControllerAdvice
public class StudentExceptionController {
	/**
	 * @return status NOT_FOUND .
	 * @exception PasswordMismatchException On input error.
	 * @see PasswordMismatchException
	 */
	@ExceptionHandler(value = PasswordMismatchException.class)
	public ResponseEntity<String> passwordMismatchException(PasswordMismatchException exception) {

		JSONObject j = new JSONObject();
		j.put("Code", "Error-102");
		j.put("description", CRSConstants.PASSWORD_MISMATCH);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

	/**
	 * @return status NOT_FOUND .
	 * @exception PaymentNotFoundException On input error.
	 * @see PaymentNotFoundException
	 */
	@ExceptionHandler(value = PaymentNotFoundException.class)
	public ResponseEntity<String> passwordMismatchException(PaymentNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "Error-404");
		j.put("description", CRSConstants.PAYMENT_NOT_FOUND);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

	/**
	 * @return status NOT_ACCEPTABLE .
	 * @exception PaymentFaildException On input error.
	 * @see PaymentFaildException
	 */
	@ExceptionHandler(value = PaymentFaildException.class)
	public ResponseEntity<String> paymentFailedException(PaymentFaildException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-105");
		j.put("description", CRSConstants.PAYMENT_FAILED);

		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(j.toString());
	}

	/**
	 * @return status NOT_FOUND .
	 * @exception ViewGradeException On input error.
	 * @see ViewGradeException
	 */
	@ExceptionHandler(value = ViewGradeException.class)
	public ResponseEntity<String> viewGradeException(ViewGradeException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-106");
		j.put("description", "Grades not found please check Student Id");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

	/**
	 * @return status NOT_FOUND .
	 * @exception StudentReportCardNotFoundException On input error.
	 * @see StudentReportCardNotFoundException
	 */
	@ExceptionHandler(value = StudentReportCardNotFoundException.class)
	public ResponseEntity<String> studentReportNotFoundException(StudentReportCardNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-107");
		j.put("description", CRSConstants.REPORT_CARD_NOT_FOUND);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

}
