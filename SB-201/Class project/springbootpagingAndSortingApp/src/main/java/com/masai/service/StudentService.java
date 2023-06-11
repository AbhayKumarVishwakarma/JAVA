package com.masai.service;

import java.util.List;

import com.masai.model.Student;

public interface StudentService {

	
	public Student addStudent(Student student);
	
	public List<Student> getAllStudentsPageWise(Integer pageNumber, Integer numberOfRecords);
	
	
	public List<Student> getSortedStudentListWithField(String field, String direction);
	
	
}
