package com.abd.integration;

import com.abd.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testRegisterEmployee() throws Exception {
        // Create an Employee object to send in the request
        Employee employee = new Employee();
        employee.setName("John Doe");
        employee.setAddress("123 Main St");
        employee.setSalary(50000);

        // Convert the Employee object to JSON
        String employeeJson = objectMapper.writeValueAsString(employee);

        // Perform the HTTP POST request to the /employee/register endpoint
        ResultActions result = mockMvc.perform(post("/employee/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employeeJson))
                .andExpect(status().isCreated());

        // Check if the response contains the registered Employee data
        result.andExpect(jsonPath("$.name").value("John Doe"));
        result.andExpect(jsonPath("$.address").value("123 Main St"));
        result.andExpect(jsonPath("$.salary").value(50000));
    }
}
