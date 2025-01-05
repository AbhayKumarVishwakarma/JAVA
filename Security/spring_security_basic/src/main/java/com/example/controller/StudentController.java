package com.example.controller;

import com.example.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>(List.of(
            new Student(1, "Ram", 34),
            new Student(2, "Shyam", 56),
            new Student(3, "Hari", 78),
            new Student(4, "Sita", 90)
    ));

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentList;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        studentList.add(student);
        return student;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

}
