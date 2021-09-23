package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import java.util.*;
public interface CourseRepository extends CrudRepository<Course, String> {
	public List<Topic> findByCourseId(String courseId);
}
