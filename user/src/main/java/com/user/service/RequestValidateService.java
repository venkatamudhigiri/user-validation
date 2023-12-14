package com.user.service;

import org.springframework.stereotype.Service;

import com.user.entity.UserDetails;
import com.user.model.JwtRequest;

@Service
public class RequestValidateService {

	public boolean validateRequest(JwtRequest request, UserDetails userDetails) {

		String reqUser = request.getUsername();
		String reqPassword = request.getPassword();

		String userName = userDetails.getUsername();
		String password = userDetails.getPassword();

		if (reqUser.equals(userName) && reqPassword.equals(password)) {
			return true;
		}
		return false;
	}
}
