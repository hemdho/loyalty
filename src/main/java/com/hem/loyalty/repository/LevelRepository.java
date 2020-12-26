package com.hem.loyalty.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.hem.loyalty.model.Level;

public interface LevelRepository extends MongoRepository<Level,String>{

	@Query(value="{'name':{$regex: ?0} , 'company.id':?1 }",fields = "{'name':1,'description':1}")
	List<Level> findByName(String name,String companyId);
}
