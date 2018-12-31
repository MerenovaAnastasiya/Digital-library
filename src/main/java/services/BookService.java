package services;

import models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBook(Long id);
}
