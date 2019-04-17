//package com.merenaas.services;
//
//import com.merenaas.forms.CheckoutForm;
//import com.merenaas.forms.SignUpForm;
//import com.merenaas.models.Basket;
//import com.merenaas.models.Book;
//import com.merenaas.models.Order;
//import com.merenaas.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.merenaas.repositories.BasketRepository;
//import com.merenaas.repositories.BookRepository;
//import com.merenaas.repositories.OrderRepository;
//import com.merenaas.repositories.UserRepository;
//
//import java.sql.SQLException;
//import java.time.LocalDate;
//import java.util.*;
//
//
//@Service
//public class OrderServiceImpl implements OrderService {
//    @Autowired
//    private OrderRepository orderRepository;
//    @Autowired
//    private BasketRepository basketRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//
//    public OrderServiceImpl(OrderRepository orderRepository, BasketRepository basketRepository,UserRepository userRepository) {
//        this.orderRepository = orderRepository;
//        this.basketRepository = basketRepository;
//        this.userRepository = userRepository;
//    }
//
//
//    @Override
//    public void checkOut(CheckoutForm checkoutForm, Long userId){
//        User user = userRepository.findOne(userId).get();
//        Order order = Order.builder()
//                .address(checkoutForm.getAddress())
//                .date(checkoutForm.getDate())
//                .userFirstName(checkoutForm.getUserFirstName())
//                .userLastName(checkoutForm.getUserLastName())
//                .phone(checkoutForm.getPhone())
//                .email(checkoutForm.getEmail())
//                .comment(checkoutForm.getComment())
//                .user(user)
//                .books(new HashSet<>())
//                .build();
//        try {
//            orderRepository.save(order);
//            Long basketId = user.getBasket().getId();
//            Set<Book> books = basketRepository.findOne(basketId).get().getBooks();
//            orderRepository.saveOrder(books, order);
//            basketRepository.delete(basketId);
//        } catch (SQLException e) {
//            throw new IllegalArgumentException("Не удалось содать заказ через service");
//        }
//    }
//}
