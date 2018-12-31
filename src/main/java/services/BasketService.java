package services;

import models.Basket;
import models.Book;
import models.User;

import java.sql.SQLException;
import java.util.Map;

public interface BasketService {
    Basket getBasketById(Long id);
    Map<Book, Integer> getUserBooks(Basket basket);
}
