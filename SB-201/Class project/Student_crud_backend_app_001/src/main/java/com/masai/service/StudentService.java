package com.masai.service;

import java.util.List;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;

public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public List<Student> getAllStudents()throws StudentException;
	
	public Student getStudentByRoll(Integer roll)throws StudentException;
	
	public Student deleteStudentbyRoll(Integer roll) throws StudentException;

	//whole object updation
	public Student updateStudentDetails(Integer roll, Student student)throws StudentException;
	
	//partial updation
	public Student updateStudentMarks(Integer roll, Integer graceMarks)throws StudentException;
	
	public List<Student> getStudentByName(String name)throws StudentException;
	
	
	public List<StudentDTO> getStudentNameAndMarks()throws StudentException;
	
}
