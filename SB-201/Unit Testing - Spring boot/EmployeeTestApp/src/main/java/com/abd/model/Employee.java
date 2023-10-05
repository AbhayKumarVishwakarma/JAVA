package com.abd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employeeId;

    @Size(min = 3, max = 10, message = "Name Length should be min 3 and max 10")
    @NotNull(message = "name is mandatory")
    private String name;

    @NotNull(message = "Address is mandatory")
    private String address;

    @NotNull(message = "Salary is mandatory")
    @Min(value = 10000, message = "Salary should be minimum 10000")
    @Max(value = 100000, message = "Salary should be maximum 100000")
    private Integer salary;

}
