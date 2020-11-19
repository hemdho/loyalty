package com.hem.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hem.auth.model.User;

public interface UserRepository extends MongoRepository<User, String> {

	 Optional<User> findByUsername(String username);
	 User findByEmail(String email);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
	  
	  @Query("select u from User u where email=?1 or userId=?1")
		User findByEmailOrId(String para);
}
