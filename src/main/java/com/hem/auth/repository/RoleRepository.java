package com.hem.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.auth.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

}
