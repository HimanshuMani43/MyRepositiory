package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
@RestController
public class HelloWorld {

	
	@Autowired
	CourseService courseService;
	
	@RequestMapping(method=RequestMethod.POST,value="/description")
	public String hello(@RequestBody Course course) {
		System.out.print(course.courseDescription);
		return course.courseDescription;
	}
	@RequestMapping("/courseDetail")
	public ArrayList<Course> getCourse() {
		Topic topic1 = new Topic("1","FirstTopic","First Topic Description", "First Topic Heading");
		Course course1 = new Course("1","This is description Of First Course","Course1",topic1);
		
		Topic topic2 = new Topic("2","SecondTopic","Second Topic Description", "Second Topic Heading");
		Course course2 = new Course("2","This is description Of Second Course","Course2",topic2);
		ArrayList<Course> coursesList = new ArrayList<Course>();
		coursesList.add(course1);
		coursesList.add(course2);
		return coursesList;
	}
	
	@RequestMapping("/getTopicOfCourseById")
	public ArrayList<Topic> getTopicByCourseId(){
		ArrayList<Topic> topic = new ArrayList<Topic>();
		ArrayList<Course> getCourses= courseService.getCourses();
		int totalCourses = 0;
		while(totalCourses< getCourses.size()) {
			Course crs = getCourses.get(totalCourses);
			topic.add(crs.topic);
		}
		System.out.print(topic.toString());
		return topic;
	}
	
	@RequestMapping("/getCourseList")
	public ArrayList<Course> ArrayListCourses() {
		ArrayList<Course> course = courseService.getCourses();
		return course;	
	}
	@RequestMapping(method= RequestMethod.POST, value="/addCourse")
	public void addCourse(@RequestBody Course course) {
		courseService.addCourse(course);
	}
	
	@RequestMapping(method= RequestMethod.POST, value="/topicListOfCourse")
	public List<Topic> getTopicListFormCourseId(@RequestBody String courseId){
		ArrayList<Topic> courseTopic = new ArrayList<Topic>();
		courseService.getTopicFromCourse(courseId).forEach(courseTopic::add);
		return courseTopic;
	}
	
	@RequestMapping("/deleteCourses")
	public void deleteCourses() {
		courseService.deleteAllCourses();
	}

	
}
