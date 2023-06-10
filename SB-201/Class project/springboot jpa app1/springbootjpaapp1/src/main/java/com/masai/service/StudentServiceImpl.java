package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Override
	public Student saveStudent(Student student) {
		
		
		System.out.println(studentRepository.getClass().getName());
		
		Student savedStudent= studentRepository.save(student);
		
		return savedStudent;
	}


	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException{
		
		
		Optional<Student> opt= studentRepository.findById(roll);
		
		
		if(opt.isPresent()) {
			
			Student existingStudent= opt.get();
			
			return existingStudent;
			
		}else {
			throw new StudentException("Student not found with roll "+roll);
		}
		
		
	}


	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		
		List<Student> students= studentRepository.findAll();
		
		if(students.isEmpty())
			throw new StudentException("No Student found..");
		else
			return students;
		
		
		
	}

	
	
}
