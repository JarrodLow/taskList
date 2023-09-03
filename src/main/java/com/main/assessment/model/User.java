package com.main.assessment.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.main.assessment.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Setter
@Getter
@Table(name="user")
public class User extends BaseEntity {

	@NotBlank
	@Email
	@Column(nullable = false, length = 100)
	private String email;
	@NotBlank
	@Column(nullable = false, length = 50)
	private String name;
	
	@NotBlank
	@Column(nullable = false, length = 50)
	private String lastname;
	
	@NotBlank
	@Column(nullable = false, length = 100)
	private String username;
	
	@JsonIgnore
	@Column(length = 200)
	private String password;
	
	@Column(nullable = false, length = 25)
	private String phone;
	
	@Column(nullable = false, name= "isaccountnonexpired")
	private Boolean isaccountnonexpired=true;
	
	@Column(nullable = false, name= "isaccountnonlocked")
	private Boolean isaccountnonlocked=true;
	
	@Column(nullable = false, name = "iscredentialsnonexpired")
	private Boolean iscredentialsnonexpired=true;

	@Column(nullable = false, name="isenabled")
	private Boolean isenabled=true;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles =new ArrayList<>();
	
	//Attributes for Social Provider
	@Column(length=100)
	private String providerId;
	
	@Column(length=30)
	@Enumerated(EnumType.STRING)
	private ProviderNameEnum provider;
	
	@Column(length=400)
	private String imageUrl;
	

	
}
