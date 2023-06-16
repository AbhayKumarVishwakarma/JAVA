package com.masai.service;

import com.masai.exception.BookException;
import com.masai.model.ObjectDTO;

import java.util.List;

public interface ReaderService {
    public ObjectDTO bookByIdReader(Integer id, Integer cusId) throws BookException;
    public List<ObjectDTO> allBookReader(Integer cusId) throws BookException;
}
