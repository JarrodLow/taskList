package com.main.assessment.repository;

import com.main.assessment.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findById(Long id);
	Optional<User> findByEmailOrUsername(String email, String username);
	Boolean existsByEmail (String email);
	Boolean existsByUsername (String username);
	Boolean existsByPhone (String phone);
	List<User> findAll();
	Boolean existsByProviderId(String providerId);
	Optional<User> findByProviderId(String providerId);
}
