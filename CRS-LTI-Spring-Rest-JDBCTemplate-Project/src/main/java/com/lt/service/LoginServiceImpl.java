package com.lt.service;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lt.bean.UserLogin;
import com.lt.exception.InvalidCredentialsException;
import com.lt.repository.LoginRepository;

@Service
public class LoginServiceImpl {

	@Autowired
	LoginRepository loginRepo;
	/**
     * This is userLogin 
     * @param userName
     * @param password
     * @exception InvalidCredentialsException
     * @return 1
     */
	public int userLogin(String credentials) throws InvalidCredentialsException {
		JSONObject jsonObj = new JSONObject(credentials);
		String userName = jsonObj.getString("userName");
		String passWord = jsonObj.getString("password");
		List<UserLogin> login = loginRepo.userLogin(userName, passWord);
		if (login.size() == 0)
			throw new InvalidCredentialsException();

		return 1;

	}

}
