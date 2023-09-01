package com.main.assessment.repository;


import com.main.assessment.model.Role;
import com.main.assessment.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	public List<Role> findAll();
	public Role findByName(RoleName rolename );

}
