package com.masai.repository;

import com.masai.model.Book;
import com.masai.model.ObjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("SELECT new com.masai.model.ObjectDTO(b.name, b.author, b.publication, b.category, b.page, b.price) FROM Book b WHERE b.id = ?1")
    public ObjectDTO getBookByIdReader(Integer id);

    @Query("SELECT new com.masai.model.ObjectDTO(b.name, b.author, b.publication, b.category, b.page, b.price) FROM Book b")
    public List<ObjectDTO> getAllBookReader();

}
