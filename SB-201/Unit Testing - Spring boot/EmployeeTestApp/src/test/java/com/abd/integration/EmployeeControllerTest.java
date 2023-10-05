package com.abd.integration;

import com.abd.exception.MyErrorDetails;
import com.abd.model.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "/application-test.properties")
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Employee can be created")
    public void testRegisterEmployeeHandler_whenValidDetailsProvided_returnRegisteredEmployee() throws Exception {

        // Arrange
        Employee employee = new Employee();
        employee.setName("Vijay");
        employee.setAddress("delhi");
        employee.setSalary(90000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee,headers);

        // Act
        ResponseEntity<Employee> re = testRestTemplate.postForEntity("/employee/register", entity, Employee.class);
        Employee createdEmployee = re.getBody();

        // Assert
        assertEquals(HttpStatus.CREATED, re.getStatusCode(), "Created Status code is not 201");
        assertNotNull(createdEmployee.getEmployeeId(), "Registered Employee should have an Id");
    }

    @Test
    @DisplayName("Creating employee with not valid details")
    public void testRegisterEmployeeHandler_whenNotValidDetailsProvided_returnRegisteredEmployee() throws Exception{

        // Arrange
        Employee employee = new Employee();
        employee.setName("Vijay");
        employee.setSalary(90000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        // Act
        ResponseEntity<MyErrorDetails> response = testRestTemplate.postForEntity("/employee/register", entity, MyErrorDetails.class);
        MyErrorDetails details = response.getBody();

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Validation error!", details.getMessage());
        assertEquals("Address is mandatory", details.getDetails());
    }

    @Test
    @DisplayName("Testing update employee")
    public void testUpdateEmployeeHandler() throws Exception {

        Employee employee = new Employee();
        employee.setName("Vijay");
        employee.setAddress("delhi");
        employee.setSalary(90000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        ResponseEntity<Employee> re = testRestTemplate.postForEntity("/employee/register", entity, Employee.class);

        ResponseEntity<Employee> response = testRestTemplate.exchange("http://localhost:8888/employee/update/1?address=Mumbai", HttpMethod.PUT, entity, Employee.class);
        Employee updatedEmployee = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode(), "Update status code is not 200");;
        assertEquals(updatedEmployee.getAddress(), "Mumbai", "Update methods not working!");
    }

    @Test
    @DisplayName("Testing find employee with valid id")
    public void testFindEmployeeHandler() throws Exception{

        Employee employee = new Employee();
        employee.setName("Vijay");
        employee.setAddress("delhi");
        employee.setSalary(90000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        ResponseEntity<Employee> re = testRestTemplate.postForEntity("/employee/register", entity, Employee.class);

        ResponseEntity<Employee> response = testRestTemplate.exchange("http://localhost:8888/employee/find/1", HttpMethod.GET, entity, Employee.class);
        Employee foundEmployee = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foundEmployee.getName(), "Vijay");
    }

    @Test
    @DisplayName("Testing delete employee")
    public void testDeleteEmployeeHandler() throws Exception{

        Employee employee = new Employee();
        employee.setName("Vijay");
        employee.setAddress("delhi");
        employee.setSalary(90000);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);

        ResponseEntity<Employee> re = testRestTemplate.postForEntity("/employee/register", entity, Employee.class);

        ResponseEntity<Employee> response = testRestTemplate.exchange("http://localhost:8888/employee/delete/1", HttpMethod.DELETE, entity, Employee.class);
        Employee foundEmployee = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(foundEmployee.getName(), "Vijay");
    }
}
