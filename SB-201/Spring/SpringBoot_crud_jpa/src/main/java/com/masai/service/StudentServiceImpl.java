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
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentByRoll(Integer roll) throws StudentException {
		Optional<Student> optional = repository.findById(roll);
		return optional.orElseThrow(() -> new StudentException("Student does not exist with roll "+roll));
	}

	@Override
	public List<Student> getAllStudentDetails() throws StudentException {
		List<Student> list = repository.findAll();
		if(list.isEmpty()) throw new StudentException("Not find any student!");
		return list;
	}

	@Override
	public Student deleteStudentByRoll(Integer roll) throws StudentException {
		Student s = repository.findById(roll).orElseThrow(()-> new StudentException("Student does not exist with roll "+roll));
		repository.delete(s);
		return s;
	}

	@Override
	public Student updateStudent(Integer roll, StudentDTO student) throws StudentException {
		Optional<Student> o = repository.findById(roll);
		if(o.isPresent()) {
			Student stu = o.get();
			stu.setName(student.getName());
			stu.setAddress(student.getAddress());
			stu.setMarks(student.getMarks());
			return repository.save(stu);
		}else
			throw new StudentException("Student does not exist with roll "+roll);
	}

	@Override
	public Student updateStudentMarks(Integer roll, Integer graceMarks) throws StudentException {
		Student s = repository.findById(roll).orElseThrow(()-> new StudentException("Student does not exist with roll "+roll));
		s.setMarks(s.getMarks() + graceMarks);
		return repository.save(s);
	}

	@Override
	public List<Student> getStudentByAddress(String address) throws StudentException {
		// TODO Auto-generated method stub
		return null;
	}

}
