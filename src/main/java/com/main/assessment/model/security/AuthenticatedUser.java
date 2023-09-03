package com.main.assessment.model.security;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.main.assessment.entity.BaseEntity;
import com.main.assessment.model.ProviderNameEnum;
import com.main.assessment.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticatedUser extends BaseEntity implements UserDetails, OAuth2User {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7478279946802298801L;


	private Long id;
	
	
	private String email;

	private String name;
	
	private String lastname;
	
	private String username;

	@JsonIgnore
	private String password;
	
	private String phone;

	private boolean isAccountNonExpired;
	
	private boolean isAccountNonLocked;

	private boolean isCredentialsNonExpired;
	
	private boolean isEnabled;
	
	private String providerId;
		
	private ProviderNameEnum provider;
	
	private String imageUrl;
	
	private Map<String, Object> attributes;

	public static AuthenticatedUser getUserAuthenticated(User user, Map<String, Object> attributes) {


		return new AuthenticatedUser(user.getId(), user.getEmail(), user.getName(), user.getUsername(), user.getLastname(),
				user.getPassword(), user.getPhone(),
				user.getIsaccountnonexpired(), user.getIsaccountnonlocked(), user.getIscredentialsnonexpired(),
				user.getIsenabled(),
				user.getCreatedTime(), user.getCreatedBy(), user.getUpdatedBy(), user.getUpdatedTime(),
				user.getProviderId(),  user.getProvider(), user.getImageUrl(),  attributes
		);
	}

}
