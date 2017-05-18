package com.ebees.springboot.demo.lesson;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

	@Autowired
	private LessonRepository topicRepository;
	
	public List<Lesson> getAllLessons(String courseId) {
		List<Lesson> lessons = new ArrayList<>();
		topicRepository.findByCourseId(courseId)
			.forEach(lessons::add);
		return lessons;
	}

	public Lesson getLesson(String id) {
		return topicRepository.findOne(id);
	}

	public void addLesson(Lesson topic) {
		topicRepository.save(topic);
	}

	public void updateLesson(Lesson topic) {
		topicRepository.save(topic);
	}

	public void deleteLesson(String id) {
		topicRepository.delete(id);
	}
}
