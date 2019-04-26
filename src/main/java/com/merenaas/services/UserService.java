package com.merenaas.services;

import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.Order;
import com.merenaas.models.User;
import com.merenaas.models.UserRoleEnum;
import com.merenaas.repositories.BasketRepository;
import com.merenaas.repositories.OrderRepository;
import com.merenaas.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private BasketRepository basketRepository;
    private OrderRepository orderRepository;

    @Autowired
    public UserService(UserRepository userRepository, BasketRepository basketRepository,
                       PasswordEncoder passwordEncoder, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.passwordEncoder = passwordEncoder;
        this.orderRepository = orderRepository;

    }

    public void signUp(SignUpForm registrationForm) {
        Basket basket = new Basket();
        basket.setBooks(new HashSet<>());
        User user = new User();
        user.setEmail(registrationForm.getEmail());
        user.setLogin(registrationForm.getLogin());
        user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        user.setUuid(UUID.randomUUID().toString());
        user.setOrders(new HashSet<>());
        user.setBasket(basket);
        Set<UserRoleEnum> roleSet = new HashSet<>();
        roleSet.add(UserRoleEnum.USER);
        user.setRoles(roleSet);
        user.setUuid(UUID.randomUUID().toString());
        basketRepository.save(basket);
        userRepository.save(user);


    }

    public void checkOut(CheckoutForm checkoutForm, User user) {
        Order order = new Order();
        order.setAddress(checkoutForm.getAddress());
        order.setComment(checkoutForm.getComment());
        order.setUser(user);
        order.setBooks(user.getBasket().getBooks());
        orderRepository.save(order);
        user.getBasket().getBooks().clear();
    }

}
