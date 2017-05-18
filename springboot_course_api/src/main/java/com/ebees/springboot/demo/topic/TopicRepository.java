package com.ebees.springboot.demo.topic;

import org.springframework.data.repository.CrudRepository;

// CrudRepository interface accepts the Entity and the ID type
public interface TopicRepository extends CrudRepository<Topic, String> {
	
}