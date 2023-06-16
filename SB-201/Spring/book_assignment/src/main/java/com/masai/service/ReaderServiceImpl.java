package com.masai.service;

import com.masai.exception.BookException;
import com.masai.model.ObjectDTO;
import com.masai.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public ObjectDTO bookByIdReader(Integer id) throws BookException {
        ObjectDTO o = bookRepository.getBookByIdReader(id);
        if(o == null) throw new BookException("Not find any book with id: " + id);
        return o;
    }

    @Override
    public List<ObjectDTO> allBookReader() throws BookException {
        List<ObjectDTO> o = bookRepository.getAllBookReader();
        if(o.isEmpty()) throw new BookException("Not find any book");
        return o;
    }
}
