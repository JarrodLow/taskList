package com.main.assessment.security.oauth2;


import com.main.assessment.util.CookieAdminI;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;


;import static com.main.assessment.security.oauth2.CustomAuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;


@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationFailureHandler.class);
	
	@Autowired
	private CustomAuthorizationRequestRepository customAuthorizationRequestRepository;
	@Autowired
	private CookieAdminI cookieAdmin;


	
	 @Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException, ServletException {
		logger.error("The user given not permission - {}", authException.getMessage());
		String forwardFailureUrl = cookieAdmin.getCookie(REDIRECT_URI_PARAM_COOKIE_NAME, request).map(cookie->cookie.getValue()).orElse("/");
		//UrlUtils.buildFullRequestUrl(request).
		
		URIBuilder url;
		try {
			url = new URIBuilder(forwardFailureUrl);
			url.addParameter("error", authException.getMessage());
			forwardFailureUrl=url.toString();
			System.out.println(forwardFailureUrl);
			customAuthorizationRequestRepository.removeAuthorizationRequestCookie(request, response);
			this.getRedirectStrategy().sendRedirect(request, response, forwardFailureUrl);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	

	
}
