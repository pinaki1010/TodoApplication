package com.pinaki.springboot.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	
   @Autowired
	private LoginAuthenticationService loginAuthenticationService;
   
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//Request Parameter Print	
//	@RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name,ModelMap model ) {
//		//Printing Log Log debug higher and info war as per application properties  lower level selected
//		logger.debug("Request Param is {}",name);
//		logger.info("Info Level Logger is {}",name);
//		logger.warn("Warn Level Logger is {}",name);
//		model.put("name", name);
//		return "login";
//	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String gotoLoginPage(ModelMap map) {
		map.put("name", getLoginUserName());
		return "Welcome";
	}
	
	public String getLoginUserName() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}
	
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public String gotoDashboardPage(@RequestParam String name,@RequestParam String password,ModelMap model) {
//		
//		if(loginAuthenticationService.authenticateService(name, password)) {
//			
//			model.put("name", name);
//			model.put("password", password);
//			
//			return "Welcome";
//			
//		}
//		
//		model.put("errormsg","Please check your name and password again");
//		return "login";
//	}
	
}
