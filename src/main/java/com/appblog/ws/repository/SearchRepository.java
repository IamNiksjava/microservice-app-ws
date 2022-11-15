package com.appblog.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appblog.ws.entity.UserEntity;

public interface SearchRepository extends CrudRepository<UserEntity, Integer> {

	@Query(value = "select * from users where random_id=:randomId", nativeQuery = true)
	List<Object> getUserBasedonUserId(String randomId);

	
	
	
//	@Query(value = "select random_id from users where random_id=:randomId", nativeQuery = true)
//	/Object findByRandomId(String randomId);
	
	
	@Query(value = "select random_id from users where random_id=:randomId", nativeQuery = true)
	Object findByRandomId(String randomId);
	

}
