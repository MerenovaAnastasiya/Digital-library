//package com.merenaas.services;
//
//import com.merenaas.models.Book;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.merenaas.repositories.BookRepository;
//
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class BookServiceImpl implements BookService {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    public BookServiceImpl(){}
//
//    public BookServiceImpl(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
////    public List<Long> getAllBooksId() {
////        List<Book> books = bookRepository.findAll();
////        List<Long> paths = new ArrayList<>();
////        for (Book book : books) {
////            paths.add(book.getId());
////        }
////        return paths;
////    }
//
//    public Set<Book> getAllBooks() {
//        return (Set<Book>)bookRepository.findAll();
//    }
//
//    @Override
//    public Optional<Book> getBook(Long id) {
//        Optional<Optional<Book>> book = Optional.of(bookRepository.findById(id));
//        return book.orElse(null);
//    }
//
//}
