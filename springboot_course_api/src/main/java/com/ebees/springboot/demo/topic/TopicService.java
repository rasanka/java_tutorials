package com.ebees.springboot.demo.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	/*
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("1", "Spring", "Spring Description"),
			new Topic("2", "Java", "Java Description"), 
			new Topic("3", "Hibernate", "Hibernate Description")));
	*/

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String id) {
		//return topics.stream().filter(a -> a.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
		/*
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
		*/
	}

	public void deleteTopic(String id) {
		//topics.removeIf(a -> a.getId().equals(id));
		topicRepository.delete(id);
	}
}
