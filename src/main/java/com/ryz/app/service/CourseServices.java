package com.ryz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ryz.app.dao.CourseRepository;
import com.ryz.app.model.Courses;

@Service
public class CourseServices {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Courses createCourses(Courses courses)throws Exception{
		return courseRepository.save(courses);
	}

	public Courses updateCourses(Courses courses)throws Exception{
		return courseRepository.save(courses);
	}
	
	public void deleteCourses(String coursesId)throws Exception{
		 courseRepository.delete(coursesId);
	}
	public List<Courses> getAllCourses()throws Exception{
		return courseRepository.findAll();
	}
	
	public Courses getCourseById(String courseId)throws Exception{
		return courseRepository.findOne(courseId);
	}
	
}
