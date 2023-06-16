package com.masai.service;

import com.masai.exception.BookException;
import com.masai.model.Book;

import java.util.List;

public interface AuthorService {
    public Book createBook(Book book, Integer cusId);
    public Book updateBook(Integer id, Book book, Integer cusId) throws BookException;
    public Book deleteBook(Integer id, Integer cusId) throws BookException;
    public Book bookById(Integer id, Integer cusId) throws BookException;
    public List<Book> allBook(Integer cusId) throws BookException;
}
