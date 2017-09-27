package com.ryz.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ryz.app.model.Courses;


public interface CourseRepository extends JpaRepository<Courses, String> {

}
