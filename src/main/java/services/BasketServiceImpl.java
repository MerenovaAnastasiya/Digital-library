package services;

import models.Basket;
import models.Book;
import models.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.BasketRepository;
import repositories.UserRepository;

import java.sql.SQLException;
import java.util.*;

public class BasketServiceImpl implements BasketService {
    private BasketRepository basketRepository;

    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
    @Override
    public Basket getBasketById(Long id) {
        Optional<Basket> basketOptional = basketRepository.findOne(id);
        if (basketOptional.isPresent()) {
            return basketOptional.get();
        } else {
            throw new IllegalArgumentException("Не удалось получить корзину по Id через service");
        }
    }
    @Override
    public Map<Book, Integer> getUserBooks(Basket basket) {
        List<Book> books = basket.getBooks();
        Map<Book, Integer> userBooks = new HashMap<>();
        for (Book book : books) {
            if (userBooks.containsKey(book)) {
                userBooks.put(book, userBooks.get(book) + 1);
            } else {
                userBooks.put(book, 1);
            }
        }
        return userBooks;
    }
}
