package com.masai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;

    private String message;

    private boolean isLike;

    private LocalDateTime createdTime = LocalDateTime.now();

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToMany(mappedBy = "post")
    private List<Comment> commentList = new ArrayList<>();
}
