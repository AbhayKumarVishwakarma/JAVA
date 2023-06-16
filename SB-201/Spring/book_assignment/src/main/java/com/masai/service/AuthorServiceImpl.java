package com.masai.service;

import com.masai.exception.BookException;
import com.masai.model.Book;
import com.masai.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book book) throws BookException {
        Book b = bookRepository.findById(id).orElseThrow( () -> new BookException("Not find any book with id: " + id));
        if(book.getAuthorNo() != null) b.setAuthorNo(book.getAuthorNo());
        if(book.getAuthor() != null) b.setAuthor((book.getAuthor()));
        if(book.getName() != null) b.setName(book.getName());
        if(book.getPage() != 0) b.setPage(book.getPage());
        if(book.getCategory() != null) b.setCategory(book.getCategory());
        if(book.getPublication() != null) b.setPublication(book.getPublication());
        if(book.getRegistrationNumber() != null) b.setRegistrationNumber(book.getRegistrationNumber());
        return bookRepository.save(b);
    }

    @Override
    public Book deleteBook(Integer id) throws BookException {
        Book b = bookRepository.findById(id).orElseThrow( () -> new BookException("Not find any book with id: " + id));
        bookRepository.delete(b);
        return b;
    }

    @Override
    public Book bookById(Integer id) throws BookException {
        return bookRepository.findById(id).orElseThrow( () -> new BookException("Not find any book with id: " + id));;
    }

    @Override
    public List<Book> allBook() throws BookException {
        List<Book> list = bookRepository.findAll();
        if(list.isEmpty()) throw new BookException("Not find any book!");
        return list;
    }
}
