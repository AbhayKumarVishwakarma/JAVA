package com.masai.modul;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;
    private String title;
    private String description;
    private Timestamp postedAt; //(Timestamp)
    private Timestamp lastUpdatedAt = Timestamp.valueOf(LocalDateTime.now()); //(Timestamp)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Post_Tags", joinColumns = {@JoinColumn(name = "postId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Tags> tagsList;

    public Post() {
    }

    public Post(int postId, String title, String description, Timestamp postedAt, Timestamp lastUpdatedAt, List<Tags> tagsList) {
        this.postId = postId;
        this.title = title;
        this.description = description;
        this.postedAt = postedAt;
        this.lastUpdatedAt = lastUpdatedAt;
        this.tagsList = tagsList;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Timestamp postedAt) {
        this.postedAt = postedAt;
    }

    public Timestamp getLastUpdatedAt() {
        return lastUpdatedAt;
    }

//    public void setLastUpdatedAt(Timestamp lastUpdatedAt) {
//        this.lastUpdatedAt = lastUpdatedAt;
//    }

    public List<Tags> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<Tags> tagsList) {
        this.tagsList = tagsList;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", postedAt=" + postedAt +
                ", lastUpdatedAt=" + lastUpdatedAt +
                ", tagsList=" + tagsList +
                '}';
    }
}
