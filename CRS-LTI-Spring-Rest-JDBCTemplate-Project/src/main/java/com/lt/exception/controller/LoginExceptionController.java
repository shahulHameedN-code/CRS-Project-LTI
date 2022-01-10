package com.lt.exception.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lt.exception.InvalidCredentialsException;

@ControllerAdvice
public class LoginExceptionController {

	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<JSONObject> passwordMismatchException(InvalidCredentialsException exception) {
		JSONObject j = new JSONObject();
		j.put("Code", "Error-101");
		j.put("description", "Invalid Credentials");

		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(j);
	}

}
