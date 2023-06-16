package com.masai.service;

import com.masai.exception.BookException;
import com.masai.model.Book;

import java.util.List;

public interface AuthorService {
    public Book createBook(Book book);
    public Book updateBook(Integer id, Book book) throws BookException;
    public Book deleteBook(Integer id) throws BookException;
    public Book bookById(Integer id) throws BookException;
    public List<Book> allBook() throws BookException;
}
