package com.ebees.springboot.demo.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.ebees.springboot.demo.course.Course;

@Entity
public class Lesson {

	@Id
	public String id;
	public String name;
	public String description;
	
	@ManyToOne
	public Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course topic) {
		this.course = topic;
	}

	public Lesson() {
	}

	public Lesson(String id, String name, String description, String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.course = new Course(courseId, "", "", "");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
