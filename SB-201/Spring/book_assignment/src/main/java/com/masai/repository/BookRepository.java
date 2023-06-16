package com.masai.repository;

import com.masai.model.Book;
import com.masai.model.ObjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("select name, author, publication, category, page, price from book where id=?1 and role='READER'")
    public ObjectDTO getBookByIdReader(Integer id);

    @Query("select name, author, publication, category, page, price from book where role='READER'")
    public List<ObjectDTO> getAllBookReader();

}
