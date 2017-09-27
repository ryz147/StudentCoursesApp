package com.ryz.app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ryz.app.model.Courses;
import com.ryz.app.model.Students;
import com.ryz.app.service.CourseServices;

@RestController
@RequestMapping("Course")
public class CoursesController {
	
	static Logger logger = Logger.getLogger(CoursesController.class);
	
	@Autowired
	private CourseServices courseServices;
	
	@PostMapping
	public Courses createCourses (@RequestBody Courses courses) throws Exception{
		logger.info("creating course"+ courses);
		return courseServices.createCourses(courses);
	}
	
	@PutMapping
	public Courses updateCourses (@RequestBody Courses courses) throws Exception{
		logger.info("update course"+ courses);
		return courseServices.updateCourses(courses);
	}
	
	@DeleteMapping(value="/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourses(@PathVariable("courseId")String courseId) throws Exception{
		courseServices.deleteCourses(courseId);
		logger.info("delete course"+ courseId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping
	public List<Courses> getAllCourse()throws Exception{
		logger.info("Fetch all the course");
		return courseServices.getAllCourses();
	}
	@GetMapping(value="/{courseId}")
	public Courses getCoursesById(@PathVariable ("courseId") String courseId) throws Exception{
		logger.info("Fetch course by Id"+ courseId);
		return courseServices.getCourseById(courseId);
	}
	@GetMapping(value="studentDetails/{courseId}")
	public ResponseEntity<List<Students>> getStudentByRegCourseId(@PathVariable("courseId")String courseId)throws Exception{
		List<Students> slist = courseServices.getCourseById(courseId).getStudents();
		logger.info("Fetch studentdetails by CourseId");
		return new ResponseEntity<List<Students>>(slist, HttpStatus.OK);
	}

}
