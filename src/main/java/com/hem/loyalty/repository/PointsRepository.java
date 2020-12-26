package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.model.Points;

public interface PointsRepository extends MongoRepository<Points, Long> {

}
