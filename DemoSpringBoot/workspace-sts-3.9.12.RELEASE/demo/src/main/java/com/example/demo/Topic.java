package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {
	@Id
	String topicId;
	String topicName;
	String topicDescription;
	String topicHeading;
	
	
	public Topic() {
		
	}
	public Topic(String topicId, String topicName, String topicDescription, String topicHeading) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
		this.topicDescription = topicDescription;
		this.topicHeading = topicHeading;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicDescription() {
		return topicDescription;
	}
	public void setTopicDescription(String topicDescription) {
		this.topicDescription = topicDescription;
	}
	public String getTopicHeading() {
		return topicHeading;
	}
	public void setTopicHeading(String topicHeading) {
		this.topicHeading = topicHeading;
	}
	
	

}
