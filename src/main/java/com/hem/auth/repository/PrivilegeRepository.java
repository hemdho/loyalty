package com.hem.auth.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.auth.model.Privilege;

public interface PrivilegeRepository  extends MongoRepository<Privilege,Integer>{

}
