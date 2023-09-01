package com.main.assessment.service;



import com.main.assessment.model.User;
import com.main.assessment.model.security.AuthenticatedUser;

import java.util.List;
import java.util.Optional;

public interface HomeServiceI {
	
	public List<User> getAllListUser();

	public Optional<AuthenticatedUser> getAuthenticatedUser();

}
