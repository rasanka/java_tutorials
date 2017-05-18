package com.ebees.springboot.demo.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// CrudRepository interface accepts the Entity and the ID type
public interface CourseRepository extends CrudRepository<Course, String> {
	
	public List<Course> findByTopicId(String topicId);
	
	public List<Course> findByName(String name);
}