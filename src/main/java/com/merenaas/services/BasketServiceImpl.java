//package com.merenaas.services;
//
//import com.merenaas.models.Basket;
//import com.merenaas.models.Book;
//import com.merenaas.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
////import com.merenaas.repositories.BasketRepository;
////import com.merenaas.repositories.UserRepository;
//
//import java.sql.SQLException;
//import java.util.*;
//
//@Service
//public class BasketServiceImpl implements BasketService {
////    @Autowired
////    private BasketRepository basketRepository;
//
//
////    public BasketServiceImpl(BasketRepository basketRepository) {
////        this.basketRepository = basketRepository;
////    }
////    @Override
////    public Basket getBasketById(Long id) {
//////        Optional<Basket> basketOptional = basketRepository.findOne(id);
////        if (basketOptional.isPresent()) {
////            return basketOptional.get();
////        } else {
////            throw new IllegalArgumentException("Не удалось получить корзину по Id через service");
////        }
////    }
//    @Override
//    public Map<Book, Integer> getUserBooks(Basket basket) {
//        Set<Book> books = basket.getBooks();
//        Map<Book, Integer> userBooks = new HashMap<>();
//        for (Book book : books) {
//            if (userBooks.containsKey(book)) {
//                userBooks.put(book, userBooks.get(book) + 1);
//            } else {
//                userBooks.put(book, 1);
//            }
//        }
//        return userBooks;
//    }
//}
