/**
 * 
 */
package com.lt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lt.exception.InvalidCredentialsException;
import com.lt.service.LoginServiceImpl;

/**
 * @author Jeaswanth
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/crs")
public class LoginController {

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
		loginServiceImpl.userLogin(loginCredentials);

		return ResponseEntity.ok().body("Login Successful");
	}

}
