package com.merenaas.repositories;

import com.merenaas.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
//    Book findByISBN13(String isbn13);
}
