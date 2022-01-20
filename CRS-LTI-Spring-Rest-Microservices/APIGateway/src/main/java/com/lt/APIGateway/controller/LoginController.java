package com.lt.APIGateway.controller;

import org.apache.http.auth.InvalidCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.APIGateway.service.LoginServiceImpl;

@RestController
@RequestMapping("/gateway")
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginServiceImpl loginServiceImpl;

	/**
	 * This is List<UserLogin>
	 * 
	 * @param userName
	 * @param password
	 * @return login
	 */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<String> userLogin(@RequestBody String loginCredentials) throws InvalidCredentialsException {
		log.info("Entering login Controller");

		loginServiceImpl.userLogin(loginCredentials);
		log.info("Returning login Controller details");
		return ResponseEntity.ok().body("Login Successful");
	}

}
