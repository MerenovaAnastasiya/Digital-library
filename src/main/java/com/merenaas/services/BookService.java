package com.merenaas.services;

import com.merenaas.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id);
}
