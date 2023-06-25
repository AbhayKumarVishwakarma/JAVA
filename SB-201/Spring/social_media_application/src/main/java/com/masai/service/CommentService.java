package com.masai.service;

import com.masai.exception.CommentException;
import com.masai.exception.PostException;
import com.masai.model.Comment;

public interface CommentService {
    public String createComment(Comment comment, Integer postId) throws PostException;
    public String deleteComment(Integer commentId) throws CommentException;
}
