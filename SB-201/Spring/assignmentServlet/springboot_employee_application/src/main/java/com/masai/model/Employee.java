package com.masai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String position;
    private Integer salary;

    public Employee(Integer id, String name, String position, Integer salary) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
