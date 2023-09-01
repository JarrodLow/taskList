package com.main.assessment.service;

import com.mcorvera.socialapp.model.User;
import com.mcorvera.socialapp.model.security.AuthenticatedUser;

import java.util.List;
import java.util.Optional;

public interface HomeServiceI {
	
	public List<User> getAllListUser();

	public Optional<AuthenticatedUser> getAuthenticatedUser();

}
