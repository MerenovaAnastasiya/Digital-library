package services;

import models.Basket;
import models.Book;
import repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<Long> getAllBooksId() {
        List<Book> books = bookRepository.findAll();
        List<Long> paths = new ArrayList<>();
        for (Book book : books) {
            paths.add(book.getId());
        }
        return paths;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        Optional<Book> book = bookRepository.findOne(id);
        return book.orElse(null);
    }

}
