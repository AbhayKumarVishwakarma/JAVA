package com.masai;

import com.masai.model.Employee;
import com.masai.repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringbootEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEmployeeApplication.class, args);
	}

}
