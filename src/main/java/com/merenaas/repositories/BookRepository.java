package com.merenaas.repositories;

import com.merenaas.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneByIsbn13(String isbn13);
}
