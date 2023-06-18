package com.pinaki.springboot.firstwebapp.login;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
public class LoginAuthenticationService {
	
	public boolean authenticateService(String name,String password) {
		
		boolean isValidUsername = name.equalsIgnoreCase("Pinaki");
		boolean isValidPassword = password.equalsIgnoreCase("123456");
		
		return isValidUsername && isValidPassword;
	}

}
