package com.masai.controller;

import com.masai.model.Book;
import com.masai.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookservice")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping("/books/author")
    public ResponseEntity<Book> createBookHandler(@RequestBody Book book, @RequestParam Integer cusId){
        Book b = authorService.createBook(book, cusId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PutMapping("/books/{id}/author")
    public ResponseEntity<Book> updateBookHandler(@RequestBody Book book, @PathVariable Integer id, @RequestParam Integer cusId){
        Book b = authorService.updateBook(id, book, cusId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}/author")
    public ResponseEntity<Book> deleteBookHandler(@PathVariable Integer id, @RequestParam Integer cusId){
        Book b = authorService.deleteBook(id, cusId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/books/{id}/author")
    public ResponseEntity<Book> bookByIdHandler(@PathVariable Integer id, @RequestParam Integer cusId){
        Book b = authorService.bookById(id, cusId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @GetMapping("/books/author")
    public ResponseEntity<List<Book>> allBookHandler(@RequestParam Integer cusId){
        List<Book> b = authorService.allBook(cusId);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

}
