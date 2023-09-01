package com.main.assessment.controller;

import com.main.assessment.beans.AuthenticationResponse;
import com.main.assessment.beans.LoginRequest;
import com.main.assessment.beans.SignUpRequest;
import com.main.assessment.service.AuthenticationServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/app")
public class AuthenticationRestController {
	
	@Autowired
	private AuthenticationServiceI authenticationServicei;
	
	
	@PostMapping("/login")
	public AuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest login) {
		AuthenticationResponse authenticationResponse=new AuthenticationResponse();
		try {
			authenticationResponse=authenticationServicei.authenticateUser(login.getUsernameOrEmail(), login.getPassword());
		}catch( AuthenticationCredentialsNotFoundException ex){
			authenticationResponse.setError(ex.getMessage());
			
		}catch(AuthenticationException ex) {
			authenticationResponse.setError(ex.getMessage());
		}
		catch(Exception ex) {
			authenticationResponse.setError(ex.getMessage());
		}
		return authenticationResponse;
	}
	
	
	@PostMapping("/signup")
	public AuthenticationResponse authenticateUser(@Valid @RequestBody SignUpRequest signup) {
		AuthenticationResponse authenticationResponse=new AuthenticationResponse();
		try {
			authenticationResponse=authenticationServicei.registerUser(signup);
		}catch(Exception ex){
			authenticationResponse.setError(ex.getMessage());
		}
		return authenticationResponse;
	}

}
