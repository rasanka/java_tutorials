package com.ebees.springboot.demo.lesson;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// CrudRepository interface accepts the Entity and the ID type
public interface LessonRepository extends CrudRepository<Lesson, String> {
	
	public List<Lesson> findByCourseId(String courseId);
	
	public List<Lesson> findByName(String name);
}