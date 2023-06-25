package com.masai.service;

import com.masai.exception.AccountException;
import com.masai.exception.PostException;
import com.masai.model.Post;

public interface PostService {
    public String createPost(Post post) throws AccountException;
    public String likePost(Integer postId) throws PostException;
    public String deletePost(Integer postId) throws PostException;
}
