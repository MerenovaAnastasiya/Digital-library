package com.merenaas.services;

import com.merenaas.models.Book;
import com.merenaas.repositories.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    public Optional<Book> getBook(Long id) {
        return bookRepository.findById(id);
    }
    public Book getBookByIsbn13(String isbn13){
        return bookRepository.findOneByIsbn13(isbn13);
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

}
