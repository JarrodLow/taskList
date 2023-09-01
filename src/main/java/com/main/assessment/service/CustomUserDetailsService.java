package com.main.assessment.service;



import com.main.assessment.model.User;
import com.main.assessment.model.security.AuthenticatedUser;
import com.main.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;


	@Override
	public UserDetails loadUserByUsername(String emailOrUsername) throws UsernameNotFoundException {
		User user =  this.userRepository.findByEmailOrUsername(emailOrUsername,emailOrUsername)
								.orElseThrow(()->new UsernameNotFoundException("This e-mail is not registered"));
		
		
		
		UserDetails userAuthenticated= AuthenticatedUser.getUserAuthenticated(user, null /*null for local provider*/)		;
		return userAuthenticated;
	}
	
	
	public UserDetails loadUserByUsername(Long id) throws UsernameNotFoundException {
		User user =  this.userRepository.findById(id)
								.orElseThrow(()->new UsernameNotFoundException("This e-mail is not registered"));
	
		
		UserDetails userAuthenticated= AuthenticatedUser.getUserAuthenticated(user, null /*null for local provider*/)	;
		return userAuthenticated;
	}


}
