package com.ryz.app.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Courses {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String courseId;
	private String courseName;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH }, targetEntity = Students.class)
	@JoinTable(name = "Student_Course", joinColumns = {
			@JoinColumn(name = "CourseId", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "StudentId", nullable = false) })
	@JsonIgnore
	private List<Students> students = new ArrayList<>();

	public Courses() {
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

}
