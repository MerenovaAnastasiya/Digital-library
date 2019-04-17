package com.merenaas.services;

import com.merenaas.models.Book;
import com.merenaas.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookService(){}

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
//    public List<Long> getAllBooksId() {
//        List<Book> books = bookRepository.findAll();
//        List<Long> paths = new ArrayList<>();
//        for (Book book : books) {
//            paths.add(book.getId());
//        }
//        return paths;
//    }

    public List<Book> getAllBooks() {
        return (List<Book>)bookRepository.findAll();
    }


    public Optional<Book> getBook(Long id) {
        Optional<Optional<Book>> book = Optional.of(bookRepository.findById(id));
        return book.orElse(null);
    }
}
