package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.masai.exception.StudentException;
import com.masai.model.Student;
import com.masai.model.StudentDTO;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping("/studentAdd")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		Student stu = service.saveStudent(student);
		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
	}
	
	@GetMapping("/student/{roll}")
	public ResponseEntity<Student> getStudentHandler(@PathVariable Integer roll){
		Student s = service.getStudentByRoll(roll);
		return new ResponseEntity<>(s, HttpStatus.FOUND);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentDetailsHandler(){
		List<Student> students= service.getAllStudentDetails();
		return new ResponseEntity<>(students,HttpStatus.FOUND);
	}
	
	@DeleteMapping("/studentDelete/{roll}")
	public ResponseEntity<Student> deleteStudentByRollHandler(@PathVariable Integer roll){
		Student deletedStudent= service.deleteStudentByRoll(roll);
		return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
	}
	
	@PutMapping("/studentUpdate/{roll}")
	public ResponseEntity<Student> updateStudentByRollHandler(@PathVariable Integer roll, @RequestBody StudentDTO dto){
		Student updateStu = service.updateStudent(roll, dto);
		return new ResponseEntity<Student>(updateStu, HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/studentMarksUpdate/{roll}")
	public ResponseEntity<Student> updateStudentMarksHandler(@PathVariable Integer roll, @RequestParam(value = "mark", required = false, defaultValue = "20") Integer mark){
		Student updatedStudent = service.updateStudentMarks(roll, mark);
		return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);
	}
}
