package com.ryz.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ryz.app.model.Students;

public interface StudentRepositoy extends JpaRepository<Students, Long> {
	
	@Query(value="select * from students where studentAddress like ?1", nativeQuery= true)
    List<Students> getStudentByAddress(String studentAddress);


}
