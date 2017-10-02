package com.ryz.app.controller;

import java.util.ArrayList;

import java.util.List;

import javax.validation.Valid;

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

import com.ryz.app.model.Students;
import com.ryz.app.service.StudentServices;

@RestController
@RequestMapping("Student")
public class StudentsController {
	
	static Logger logger = Logger.getLogger(StudentsController.class.getName());
	
	@Autowired
	private StudentServices studentServices;

	@PostMapping
	public Students createStudents(@RequestBody @Valid Students students) throws Exception {
		logger.info("creating student"+ students);
		return studentServices.createStudent(students);
	}

	@PutMapping
	public Students updateStudents(@RequestBody Students students) throws Exception {
		logger.info("update student"+ students);
		return studentServices.updateStudent(students);
	}

	@DeleteMapping(value = "/{studentId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable("studentId") Long studentId) throws Exception {
		studentServices.deleteStudent(studentId);
		logger.info("delete student"+ studentId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping
	public List<Students> getAllStudents() throws Exception {
		logger.info("Fetch all the student");
		List<Students> studentsList = studentServices.getAllStudents();
		return studentsList;
	}

	@GetMapping("/{studentId}")
	public Students getStudentById(@PathVariable("studentId") Long studentId) throws Exception {
		logger.info("Fetch student by Id"+ studentId);
		return studentServices.getStudentById(studentId);
	}

	@GetMapping("State/{studentAddress}")
	public ResponseEntity<List<Students>> getStudentByAddress(@PathVariable("studentAddress") String studentAddress) throws Exception {
		List<Students> slist = studentServices.getStudentByAddress(studentAddress);
		logger.info("Fetch students by studentAddress");
		return new ResponseEntity<List<Students>>(slist,HttpStatus.OK);
	}


	@GetMapping("students/{count}")
	public ResponseEntity<List<Students>> getStudentsByCourses(@PathVariable("count") Long count) throws Exception{
		List<Students> courses = new ArrayList<>();
		List<Students> students = studentServices.getAllStudents();
		logger.info("Fetch students by Count");
		for (Students s : students) {
			if (s.getCourses().size() >= count) {
				courses.add(s);
			}
		}
		return new ResponseEntity<List<Students>>(courses, HttpStatus.OK);

	}
}
