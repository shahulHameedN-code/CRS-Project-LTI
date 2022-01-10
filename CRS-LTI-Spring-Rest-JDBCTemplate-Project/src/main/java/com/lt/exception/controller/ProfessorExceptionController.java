package com.lt.exception.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lt.exception.AddGradeException;
import com.lt.exception.CourseNotFoundException;

@ControllerAdvice
public class ProfessorExceptionController {

	@ExceptionHandler(value = CourseNotFoundException.class)
	public ResponseEntity<JSONObject> courseNotFoundException(CourseNotFoundException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "Error-404");
		j.put("description", "Course not foudn");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

	@ExceptionHandler(value = AddGradeException.class)
	public ResponseEntity<JSONObject> addGradeException(AddGradeException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "TEC-103");
		j.put("description", "Grades not updated! Please check Student Id and Course Id");

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(j);
	}

}
