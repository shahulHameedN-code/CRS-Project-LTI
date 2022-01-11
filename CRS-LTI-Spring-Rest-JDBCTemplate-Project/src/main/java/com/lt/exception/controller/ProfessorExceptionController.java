package com.lt.exception.controller;

import org.json.JSONObject;
import com.lt.constant.CRSConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lt.exception.AddGradeException;
import com.lt.exception.CourseNotFoundException;

@ControllerAdvice
public class ProfessorExceptionController {
	/**
	 * @return status NOT_FOUND .
	 * @exception CourseNotFoundException On input error.
	 * @see courseNotFoundException
	 */
	@ExceptionHandler(value = CourseNotFoundException.class)
	public ResponseEntity<String> courseNotFoundException(CourseNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "Error-404");
		j.put("description", CRSConstants.COURSE_NOT_FOUND);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

	/**
	 * @return status NOT_FOUND .
	 * @exception addGradeException On input error.
	 * @see addGradeException
	 */
	@ExceptionHandler(value = AddGradeException.class)
	public ResponseEntity<String> addGradeException(AddGradeException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-103");
		j.put("description", CRSConstants.GRADES_NOT_UPDATED);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j.toString());
	}

}
