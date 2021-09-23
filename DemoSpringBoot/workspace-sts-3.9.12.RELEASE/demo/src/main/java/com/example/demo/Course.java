package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	@Id
	String courseId;
	String courseDescription;
	String courseName;
	
	@ManyToOne
	Topic topic;
	
	public Course(){
	}
	
	public Course(String courseId, String courseDescription, String courseName, Topic topic) {
		super();
		this.courseId = courseId;
		this.courseDescription = courseDescription;
		this.courseName = courseName;
		this.topic = topic;
	}

	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
