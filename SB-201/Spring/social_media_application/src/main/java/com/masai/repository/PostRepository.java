package com.masai.repository;

import com.masai.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>, PagingAndSortingRepository<Post, Integer> {

    @Query("from Post")
    public Page<Post> getAllPost(Pageable pageable);
}
