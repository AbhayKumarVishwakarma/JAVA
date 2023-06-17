package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;
import com.masai.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	

	@Override
	public Student saveStudent(Student student) {
		
		Student savedStudent= studentRepository.save(student);
		
		return savedStudent;
		
	}



	@Override
	public List<Student> getAllStudents() throws StudentException {
		
		List<Student> students= studentRepository.findAll();
		
		if(students.isEmpty())
			throw new StudentException("No student available");
		
		
		
		return students;
		
	}



	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		
		Optional<Student> opt= studentRepository.findById(roll);
//		
//		if(opt.isPresent()) {
//			
//			Student student= opt.get();
//			
//			return student;
//		}else
//			throw new StudentException("Student does not exist with roll number :"+roll);
//		
		
		
		return opt.orElseThrow(() -> new StudentException("Student does not exist with roll "+roll));
		
		
		
	}



	@Override
	public Student deleteStudentbyRoll(Integer roll) throws StudentException {
		
//		Optional<Student> opt= studentRepository.findById(roll);
//			
//		if(opt.isPresent()) {
//			
//			Student existingStudent= opt.get();
//			
//			studentRepository.delete(existingStudent);
//			
//			return existingStudent;
//			
//			
//			
//		}else
//			throw new StudentException("Student does not exist with roll :"+roll);
		

		Student existingStudent= studentRepository.findById(roll).orElseThrow(() -> new StudentException("Student does not exist with roll :"+roll));
		
			studentRepository.delete(existingStudent);
		
				return existingStudent;
		
		
		
		
		
	}



	@Override
	public Student updateStudentDetails(Integer roll, Student student) throws StudentException {
		
		
		
		Optional<Student> opt= studentRepository.findById(roll);
		
		if(opt.isPresent()) {
			
			Student existingStudent= opt.get();
			existingStudent.setName(student.getName());
			existingStudent.setAddress(student.getAddress());
			existingStudent.setMarks(student.getMarks());
			
			studentRepository.save(existingStudent);
			
			//save method will perform as saveOrUpdate based on Id field.
			//if the supplied object id is already available then it will merge the record. otherwise it will insert a new record.
			
			return student;
			
		}else
			throw new StudentException("Invalid Student supplied...");
		
		
	}



	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		
		Optional<Student> opt= studentRepository.findById(roll);
		
		if(opt.isPresent()) {
			
			
			Student exitingStudent= opt.get();
			
			exitingStudent.setMarks(exitingStudent.getMarks()+graceMarks);
			
			return studentRepository.save(exitingStudent);
			
			
			
			
		}else
			throw new StudentException("Student does not exist with roll: "+roll);
		
		
	}



	@Override
	public List<Student> getStudentByName(String name) throws StudentException {
	
		List<Student> students= studentRepository.getStudentsByName(name);
		
		
		if(students.isEmpty())
			throw new StudentException("Student does not exist with name: "+name);
		else 
			return students;
		
		
	}



	@Override
	public List<StudentDTO> getStudentNameAndMarks() throws StudentException {
		
		
		List<StudentDTO> dtos= studentRepository.getStudentNameAndMarks();
		
		if(dtos.isEmpty())
			throw new StudentException("No Student found...");
		else
			return dtos;
		
		
	}

	
	
	
	
	
	
	
	
	
}
