package com.lt.APIGateway.service;

import org.apache.http.auth.InvalidCredentialsException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.APIGateway.beans.UserLogin;
import com.lt.APIGateway.repository.LoginRepository;

@Service
public class LoginServiceImpl {

	private static Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	LoginRepository loginRepo;

	/**
	 * This is userLogin
	 * 
	 * @param userName
	 * @param password
	 * @exception InvalidCredentialsException
	 * @return 1
	 */
	public int userLogin(String credentials) throws InvalidCredentialsException {

		log.info("Entering credential details from login service");
		JSONObject jsonObj = new JSONObject(credentials);
		String userName = jsonObj.getString("userName");
		String password = jsonObj.getString("password");
		UserLogin login = loginRepo.findByUserNameAndPasswordAndIsApprovedTrue(userName, password);

		if (login == null)
			throw new InvalidCredentialsException();

		return 1;

	}

}
