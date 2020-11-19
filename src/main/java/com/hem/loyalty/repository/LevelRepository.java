package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.model.Level;

public interface LevelRepository extends MongoRepository<Level,String>{

}
