package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository coursesRepository;
	public ArrayList<Course> getCourses(){
		ArrayList<Course> courses = new ArrayList<Course>();
		coursesRepository.findAll().forEach(courses::add);
		return courses;
	}
	public void addCourse(Course course) {
		coursesRepository.save(course);
	}
	public List<Topic> getTopicFromCourse(String courseId){
		return coursesRepository.findByCourseId(courseId);
	}
	public void deleteAllCourses() {
		coursesRepository.deleteAll();
	}
}
