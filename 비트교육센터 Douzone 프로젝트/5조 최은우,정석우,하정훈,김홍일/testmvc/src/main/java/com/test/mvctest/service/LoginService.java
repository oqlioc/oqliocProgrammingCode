package com.test.mvctest.service;

import org.springframework.stereotype.Service;

import com.test.mvctest.model.UserModel;

@Service
public class LoginService {

	public boolean login(UserModel userModel) {

		if (!"root".equals(userModel.getId())) {
			return false;
		}

		if (!"root".equals(userModel.getPw())) {
			return false;
		}

		return true;
	}

}
