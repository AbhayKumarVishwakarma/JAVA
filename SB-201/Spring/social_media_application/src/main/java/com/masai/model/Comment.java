package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    private String msg;
    private LocalDateTime createdTime = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Post post;
}
