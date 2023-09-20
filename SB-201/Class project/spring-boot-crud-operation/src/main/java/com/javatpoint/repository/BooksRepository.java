package com.javatpoint.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//repository that extends CrudRepository
import com.javatpoint.model.Books;

@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>{
}
