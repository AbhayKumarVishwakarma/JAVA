package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService sService;
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> addStudentHandler(@RequestBody Student student){
		
		Student savedStudent= sService.addStudent(student);
		
		return new ResponseEntity<>(savedStudent,HttpStatus.CREATED);
	}
	
	@GetMapping("/students/{pageNumber}")
	public List<Student> getStudentPagedWiseHandler(@PathVariable("pageNumber") Integer pageNumber, @RequestParam("numberOfRecords") Integer numberOfRecords){
	
		return sService.getAllStudentsPageWise(pageNumber, numberOfRecords);
	
	}

	
	@GetMapping("/getSortedStudents/{field}")
	public List<Student> getSortedStudentListHandler(@PathVariable("field") String field, @RequestParam("direction") String direction){
		
		return sService.getSortedStudentListWithField(field, direction);
		
	}
	
	
	
	
	
	
}
