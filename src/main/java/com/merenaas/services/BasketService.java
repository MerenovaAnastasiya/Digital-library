package com.merenaas.services;

import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import com.merenaas.repositories.BasketRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
//import com.merenaas.repositories.BasketRepository;
//import com.merenaas.repositories.UserRepository;

import java.sql.SQLException;
import java.util.*;

@Service
@NoArgsConstructor
public class BasketService {
    private BasketRepository basketRepository;

    @Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void addBookToBasket(Optional<Book> book, Basket basket) {
//        System.out.println(basket.getId());
        System.out.println(basket.getId() + " " + book.get().getId());
        basket.getBooks().add(book.get());
        basketRepository.addBookToBasket(basket.getId(), book.get().getId());
    }
}
