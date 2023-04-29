package com.masai.dao;

import com.masai.modul.Post;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tagId;
    private String tagName;
    @ManyToMany(mappedBy = "tagsList", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Post> postList;
}
