package com.main.assessment.controller;


import com.main.assessment.model.User;
import com.main.assessment.model.security.AuthenticatedUser;
import com.main.assessment.service.HomeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
	@Autowired
	private HomeServiceI homeService;
	
	@Value("${app.jwtSecret}")
    private String jwtSecret;

	@GetMapping("/")
	public String homepage() {
		
		return "hola mundo";
	}
	@GetMapping("/list-user")
	public List<User> getUserList() {
		List<User> users= homeService.getAllListUser();
		return users;
	}
	
	@GetMapping("/auth-user")
	public AuthenticatedUser getAuthenticatedUser() {
		AuthenticatedUser authenticatedUser= homeService.getAuthenticatedUser().get();
		return authenticatedUser;
	}
	
	
	@GetMapping("/read-property")
	public String getProperty(){
		return this.jwtSecret;
	}
}


