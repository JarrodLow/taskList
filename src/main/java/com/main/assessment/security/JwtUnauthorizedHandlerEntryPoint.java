package com.main.assessment.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtUnauthorizedHandlerEntryPoint implements AuthenticationEntryPoint {
	 private static final Logger logger = LoggerFactory.getLogger(JwtUnauthorizedHandlerEntryPoint.class);
	   

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		 logger.error("Responding with unauthorized error. Message - {}", authException.getMessage()+". Your credential is not valid");
		 response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage()+". Your credential is not valid");
	  
		
	}

}
