package com.hem.auth.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.auth.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

	Optional<Role> findByName(String name);
}
