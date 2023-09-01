package com.main.assessment.service;

import com.mcorvera.socialapp.beans.AuthenticationResponse;
import com.mcorvera.socialapp.beans.SignUpRequest;
import com.mcorvera.socialapp.model.security.AuthenticatedUser;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;

import java.util.Optional;

public interface AuthenticationServiceI {

	public AuthenticationResponse authenticateUser(String usernameOrEmail, String password) throws AuthenticationCredentialsNotFoundException, AuthenticationException ;
	
	public AuthenticationResponse registerUser(SignUpRequest signup);
	
	public Optional<AuthenticatedUser> getAuthenticatedUser(); //Get Profile of user
	
}
