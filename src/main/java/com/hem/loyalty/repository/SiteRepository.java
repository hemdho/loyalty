package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hem.loyalty.model.Site;

public interface SiteRepository extends MongoRepository<Site,String>{

}
