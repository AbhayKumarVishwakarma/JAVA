package com.masai;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/studentapp")
public class HelloWorldController {
	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHello() {
		return "Welcome to Spring Boot...";
	}
	
	@GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student1 getStudent() {
		return new Student1(10, "Ankit", 980);
	}
	
	@GetMapping(value = "/students")
	public List<Student1> getAllStudents(){
		List<Student1> list = new ArrayList<>();
		list.add(new Student1(1, "Ankit", 980));
		list.add(new Student1(2, "Suraj", 940));
		list.add(new Student1(3, "Raj", 910));
		list.add(new Student1(4, "Ankita", 970));
		list.add(new Student1(5, "Tony", 920));
		list.add(new Student1(6, "Anu", 930));
		list.add(new Student1(10, "Ram", 850));
		list.add(new Student1(12, "Ramesh", 650));
		list.add(new Student1(13, "Ravi", 750));
		list.add(new Student1(14, "amit", 950));
		list.add(new Student1(15, "Anurag", 940));

		return list;
	}
	
	@GetMapping(value = "/studentCollages")
	public List<Student> getAllStudentsCollage(){
		List<Student> list = new ArrayList<>();
		list.add(new Student(1, "Ankit", 980, new Collage(2, "BHU", "Vanarasi")));
		list.add(new Student(2, "Suraj", 940, new Collage(1, "DU", "Dehli")));
		list.add(new Student(3, "Raj", 910, new Collage(2, "BHU", "Vanarasi")));
		list.add(new Student(4, "Ankita", 970, new Collage(3, "AU", "Prayagraj")));
		list.add(new Student(5, "Tony", 920, new Collage(3, "AU", "Prayagraj")));
		list.add(new Student(6, "Anu", 930, new Collage(3, "AU", "Prayagraj")));
		list.add(new Student(10, "Ram", 850, new Collage(1, "DU", "Dehli")));
		list.add(new Student(12, "Ramesh", 650, new Collage(2, "BHU", "Vanarasi")));
		list.add(new Student(13, "Ravi", 750, new Collage(2, "BHU", "Vanarasi")));
		list.add(new Student(14, "amit", 950, new Collage(1, "DU", "Dehli")));

		return list;
	}
	
	@GetMapping(value = "/student/{roll}")  //http://localhost:8080/studentapp/student/7
	public Student1 getStudentPath(@PathVariable(value = "roll") Integer roll) {
		return new Student1(roll, "Ruppa", 780);
	}
	
	@GetMapping(value = "/student/{roll}/{name}/{marks}") // http://localhost:8080/studentapp/student/8/Radha/990
	public Student1 getStudentPaths(@PathVariable Integer roll,
			                        @PathVariable String name,
			                        @PathVariable Integer marks) {
		return new Student1(roll, name, marks);
	}
	
	@GetMapping(value = "/studentRP") //http://localhost:8080/studentapp/student?roll=9
	public Student1 getStudentReqParam(@RequestParam Integer roll) {
		return new Student1(roll, "Bebo", 870);
	}
	
	@GetMapping(value = "/getstudent") //http://localhost:8080/studentapp/getstudent?roll=21&name=Meena&marks=660
	public Student1 getStudentReqParams(@RequestParam("roll") Integer roll,
			                            @RequestParam String name,
			                            @RequestParam("marks") Integer marks) {
		return new Student1(roll, name, marks);
	}
	
	@PostMapping(value = "saveStudent")
	public String saveStudent(@RequestBody Student1 stu) {
		return "Student details " + stu + " saved...";
	}

	@PutMapping(value = "/updateStudent/{graceMarks}")
	public Student1 updateStudent(@RequestBody Student1 student1, @PathVariable("graceMarks") int gmarks){
		student1.setMarks(student1.getMarks() + gmarks);
		return student1;
	}
}
