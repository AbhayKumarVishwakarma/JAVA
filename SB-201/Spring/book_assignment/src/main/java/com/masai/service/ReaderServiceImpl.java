package com.masai.service;

import com.masai.exception.BookException;
import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.model.ObjectDTO;
import com.masai.repository.BookRepository;
import com.masai.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ObjectDTO bookByIdReader(Integer id, Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("READER")) throw new RuntimeException("You can't perform this operation!");
        ObjectDTO o = bookRepository.getBookByIdReader(id);
        if(o == null) throw new BookException("Not find any book with id: " + id);
        return o;
    }

    @Override
    public List<ObjectDTO> allBookReader(Integer cusId) throws BookException {
        Customer customer = customerRepository.findById(cusId).orElseThrow( () -> new CustomerException("Not find any customer with id: " + cusId));
        if(!customer.getRole().equals("READER")) throw new RuntimeException("You can't perform this operation!");
        List<ObjectDTO> o = bookRepository.getAllBookReader();
        if(o.isEmpty()) throw new BookException("Not find any book");
        return o;
    }
}
