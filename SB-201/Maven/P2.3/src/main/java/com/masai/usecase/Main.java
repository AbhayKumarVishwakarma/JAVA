package com.masai.usecase;

import com.masai.modul.Post;
import com.masai.modul.Tags;
import com.masai.utils.EMUtils;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        EntityManager em = EMUtils.getConnection();

        Post post = new Post();
        post.setTitle("Pollution");
        post.setDescription("Today, pollution is the biggest problem in the world");
        post.setPostedAt(Timestamp.valueOf(LocalDateTime.now()));


        Tags tags = new Tags();
        tags.setTagName("one");
        tags.setPostList(List.of(post));
        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();

        //public void addPost(Post post); [Points: 1 ]**
        //- this method should add a post with 4 tags.
        post.setTagsList(List.of(tags));
        em.getTransaction().begin();
        em.persist(post);
        em.getTransaction().commit();

        //public Post getPost(int postId); [Points: 0.75 ]**
        //- This method should get the Post along with the List of Tags.
        //- If postId not exist then throw a PostNotFoundException
        Post post1 = em.find(Post.class,1);
        System.out.println("\n" + post1);


        //public Tags getTags(int tagId); [Points: 0.75 ]**
        //- This method should get the Tag along with the List of Posts.
        //- If tagId not exist then throw a TagNotFoundException
        Tags tags1 = em.find(Tags.class,1);
        System.out.println("\n" + tags1);

        em.close();
        System.out.println("\ndone...");
    }
}