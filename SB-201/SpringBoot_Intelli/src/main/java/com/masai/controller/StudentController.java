package com.masai.controller;

import com.masai.model.Student2;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/studentapp")
public class StudentController {
    private Map<Integer, Student2> map = new HashMap<>();
    @PostConstruct
    public void init() {

        map.put(10, new Student2(10, "Ram", "Delhi", 800));
        map.put(11, new Student2(11, "Sunil", "Delhi", 820));
        map.put(12, new Student2(12, "Ramesh", "Chennai", 840));
        map.put(13, new Student2(13, "Manoj", "Kolkata", 700));
        map.put(14, new Student2(14, "Suresh", "Pune", 600));

    }
    @GetMapping(value = "/students2")
    public ResponseEntity<List<Student2>> getAllStudent2Handler(){
        Collection<Student2> collection= map.values();
        List<Student2> list = new ArrayList<>(collection);
        ResponseEntity<List<Student2>> res = new ResponseEntity<>(list, HttpStatus.OK);
        return res;
    }
    @PostMapping(value = "/newStudent2Add")
    public ResponseEntity<String> addStudent2Handler(@Valid @RequestBody Student2 student2){
        map.put(student2.getRoll(), student2);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("MyNewHeader", "new header created...");
        httpHeaders.add("MyNewHeader2", "new header2 created...");
        return new ResponseEntity<>("New Student added: " + student2, httpHeaders, HttpStatus.CREATED);
    }
    @GetMapping("/students2/{roll}")
    public Student2 getStudentByRollHandler(@PathVariable Integer roll) {
        if(map.containsKey(roll)) {
            return map.get(roll);
        }else
            throw new IllegalArgumentException("Student does not exist with Roll : " + roll);
    }
    @PutMapping("/students2/{roll}")
    public String updateStudentHandler(@PathVariable Integer roll, @RequestBody Student2 student2){
        if(map.containsKey(roll)){
            Student2 s = map.get(roll);
            s.setName(student2.getName());
            s.setAddress(student2.getAddress());
            map.put(roll, s);
            return "Student updated...";
        }else
            throw new IllegalArgumentException("Student does not exist with Roll : " + roll);
    }
    @PatchMapping("students2/{roll}") // http://localhost:8080/students2/10?gmarks=50
    public String updateStudentMarksHandler(@PathVariable Integer roll, @RequestParam Integer gMark){
        if(map.containsKey(roll)){
            Student2 s = map.get(roll);
            s.setMarks(s.getMarks() + gMark);
            map.put(roll, s);
            return "Student marks is graced by "+ gMark;
        }else
            throw new IllegalArgumentException("Student does not exist with Roll : " + roll);
    }
	@DeleteMapping("/students2/{roll}")
	public String deleteStudentByRollHandler(@PathVariable Integer roll) {
        if(map.containsKey(roll)){
            map.remove(roll);
            return "Student deleted...";
        }else
            throw new IllegalArgumentException("Student does not exist with Roll : " + roll);
	}

    @RequestMapping(value = "/hi/{num}", method = RequestMethod.GET)
    public String sayHello(@PathVariable Integer num) {
        if(num > 100) throw new IllegalArgumentException("Number should be less than 100");
        int x = 1000/num;
        return "Welcome to Spring Boot...";
    }
}
