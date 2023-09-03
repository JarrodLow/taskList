package com.main.assessment.model;


import com.main.assessment.entity.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Setter
@Getter
@Table(name = "roles")
public class Role extends BaseEntity {

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleName name;
	@NotBlank
	@Column(nullable = false)
	private String description;


}
