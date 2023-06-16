package com.masai.controller;

import com.masai.model.Book;
import com.masai.model.ObjectDTO;
import com.masai.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookservice")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("books/{id}/reader")
    public ResponseEntity<ObjectDTO> bookByIdHandler(@PathVariable Integer id, @RequestParam Integer cusId){
        ObjectDTO o = readerService.bookByIdReader(id, cusId);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

    @GetMapping("books/reader")
    public ResponseEntity<List<ObjectDTO>> allBookHandler(@RequestParam Integer cusId){
        List<ObjectDTO> o = readerService.allBookReader(cusId);
        return new ResponseEntity<>(o, HttpStatus.OK);
    }

}
