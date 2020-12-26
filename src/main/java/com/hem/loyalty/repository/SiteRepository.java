package com.hem.loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hem.loyalty.model.Site;

public interface SiteRepository extends MongoRepository<Site,String>{
	@Query( "{'company.id':?0 , 'id':?1}")
	Site getSite(String companyId,String siteId);
}
