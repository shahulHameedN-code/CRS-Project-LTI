package com.lt.application.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.application.entity.UserLogin;
import com.lt.application.exception.InvalidCredentialsException;
import com.lt.application.repository.LoginRepository;

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
