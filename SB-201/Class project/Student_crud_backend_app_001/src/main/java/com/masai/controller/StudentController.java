package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Student;
import com.masai.model.StudentDTO;
import com.masai.service.StudentService;
import com.masai.service.StudentServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

	
	@Autowired
	private StudentService studentService;
	
	
	
	
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		
		Student savedStudent= studentService.saveStudent(student);
		
		
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentsHandler(){
		
		List<Student> students= studentService.getAllStudents();
		
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	
	@GetMapping("/students/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable Integer roll){
		
		
		Student student= studentService.getStudentByRoll(roll);
		
		
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/students/{roll}")
	public ResponseEntity<Student> deleteStudentByRollHandler(@PathVariable Integer roll){
		
		
		Student deletedStudent= studentService.deleteStudentbyRoll(roll);
		
		
		return new ResponseEntity<>(deletedStudent, HttpStatus.OK);
	}
	
	
	@PutMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentHandler(@PathVariable("roll") Integer roll, @RequestBody Student student){
		
		Student updatedStudent= studentService.updateStudentDetails(roll,student);
		
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK); 
		
		
		
	}
	
	
	//http://localhost:8080/students/1?gMarks=50
	
	@PatchMapping("/students/{roll}")
	public ResponseEntity<Student> updateStudentMarkshandler(@PathVariable Integer roll, @RequestParam Integer gMarks){
		
		Student updatedStudent= studentService.updateStudentMarks(roll, gMarks);
		
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getstudent/{name}")
	public ResponseEntity<List<Student>> getStudentByNameHandler(@PathVariable String name){
		
		List<Student> students= studentService.getStudentByName(name);
		
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	
	@GetMapping("/getstudentdetails")
	public ResponseEntity<List<StudentDTO>> getStudentNameAndMarkshandler(){
		List<StudentDTO> dtos= studentService.getStudentNameAndMarks();
		
		
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
	
	
}
