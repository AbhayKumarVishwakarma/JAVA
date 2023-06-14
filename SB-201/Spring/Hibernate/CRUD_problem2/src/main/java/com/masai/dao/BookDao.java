package com.masai.dao;

import com.masai.exception.BookException;
import com.masai.modul.Book;

public interface BookDao {
    public Book getBookById(int id) throws BookException;
    public String createBook(Book book);
    public String deleteBook(int id) throws BookException;
    public String updateBookPriceById(int id, int price) throws BookException;
}
