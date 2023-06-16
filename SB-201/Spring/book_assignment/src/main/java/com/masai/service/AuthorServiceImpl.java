package com.masai.service;

import com.masai.exception.BookException;
import com.masai.exception.CustomerException;
import com.masai.model.Book;
import com.masai.model.Customer;
import com.masai.repository.BookRepository;
import com.masai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Book createBook(Book book, Integer cusId) {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("AUTHOR")) throw new RuntimeException("You can't perform this operation!");
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Integer id, Book book, Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("AUTHOR")) throw new RuntimeException("You can't perform this operation!");
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
    public Book deleteBook(Integer id, Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("AUTHOR")) throw new RuntimeException("You can't perform this operation!");
        Book b = bookRepository.findById(id).orElseThrow( () -> new BookException("Not find any book with id: " + id));
        bookRepository.delete(b);
        return b;
    }

    @Override
    public Book bookById(Integer id, Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("AUTHOR")) throw new RuntimeException("You can't perform this operation!");
        return bookRepository.findById(id).orElseThrow( () -> new BookException("Not find any book with id: " + id));;
    }

    @Override
    public List<Book> allBook(Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("AUTHOR")) throw new RuntimeException("You can't perform this operation!");
        List<Book> list = bookRepository.findAll();
        if(list.isEmpty()) throw new BookException("Not find any book!");
        return list;
    }
}
