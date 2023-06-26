package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@ToString
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer custId;

    private String name;

    @Email
    @Column(unique = true)
    private String email;

    private String password;

    private Date dob;

    private LocalDateTime createdTime = LocalDateTime.now();

    @JsonIgnore
    @OneToMany(mappedBy = "account")
    private List<Post> postList = new ArrayList<>();
}
