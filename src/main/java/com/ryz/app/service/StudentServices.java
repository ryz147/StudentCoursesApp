package com.ryz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ryz.app.dao.StudentRepositoy;
import com.ryz.app.model.Students;

@Service
public class StudentServices {

	@Autowired	
	private StudentRepositoy studentRepositoy;
	
	public Students createStudent(Students students) throws Exception{
		return studentRepositoy.save(students);
		
	}
	
	public Students updateStudent(Students students)throws Exception{
		return studentRepositoy.save(students);
			
	}
	
	public void deleteStudent(Long studentId)throws Exception{
		studentRepositoy.delete(studentId); 
	}
	
	public List<Students> getAllStudents()throws Exception{
		return studentRepositoy.findAll();
		
	}
	
	public Students getStudentById(Long studentId)throws Exception{
		return studentRepositoy.findOne(studentId);
		}
	
	public List<Students> getStudentByAddress(String studentAddress)throws Exception{
		return studentRepositoy.getStudentByAddress("%,"+studentAddress);
	}
}	
