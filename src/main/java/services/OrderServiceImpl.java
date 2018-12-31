package services;

import forms.CheckoutForm;
import forms.SignUpForm;
import models.Basket;
import models.Book;
import models.Order;
import models.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.BasketRepository;
import repositories.BookRepository;
import repositories.OrderRepository;
import repositories.UserRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import java.sql.SQLException;
//import java.util.Calendar;
//import java.util.UUID;

public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;
    private BasketRepository basketRepository;
    private UserRepository userRepository;


    public OrderServiceImpl(OrderRepository orderRepository, BasketRepository basketRepository,UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void checkOut(CheckoutForm checkoutForm, Long userId){
        User user = userRepository.findOne(userId).get();
        Order order = Order.builder()
                .address(checkoutForm.getAddress())
                .date(checkoutForm.getDate())
                .userFirstName(checkoutForm.getUserFirstName())
                .userLastName(checkoutForm.getUserLastName())
                .phone(checkoutForm.getPhone())
                .email(checkoutForm.getEmail())
                .comment(checkoutForm.getComment())
                .user(user)
                .bookList(new ArrayList<>())
                .build();
        try {
            orderRepository.save(order);
            Long basketId = user.getBasket().getId();
            List<Book> books = basketRepository.findOne(basketId).get().getBooks();
            orderRepository.saveOrder(books, order);
            basketRepository.delete(basketId);
        } catch (SQLException e) {
            throw new IllegalArgumentException("Не удалось содать заказ через service");
        }
    }
}
