package com.merenaas.services;

import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.forms.UpdateProfileForm;
import com.merenaas.models.*;
import com.merenaas.repositories.BasketRepository;
import com.merenaas.repositories.OrderRepository;
import com.merenaas.repositories.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
        User user = new User();
        user.setEmail(registrationForm.getEmail());
        user.setLogin(registrationForm.getLogin());
        user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        user.setUuid(UUID.randomUUID().toString());
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfDelivery = LocalDate.parse(checkoutForm.getDateOfDelivery(), formatter);
        LocalDate dateOfReturn = LocalDate.parse(checkoutForm.getDateOfReturn(), formatter);
        order.setDateOfDelivery(dateOfDelivery);
        order.setDateOfReturn(dateOfReturn);
        order.setDateOfOrder(LocalDate.now());
        order.setStatus(OrderStatusEnum.TREATMENT);
        order.setUser(user);
        order.setBooks(user.getBasket().getBooks());
        user.getOrders().add(order);
        orderRepository.save(order);
        user.getBasket().getBooks().clear();

    }

    public void updateInformation(UpdateProfileForm form, User user){
        //TODO delete check strings. Maybe I can check it in ftl???
        //but I tried to use Value for input and it doesn't work (((
        if(!form.getLogin().equals("")) {
            user.setLogin(form.getLogin());
        }
        if(!form.getEmail().equals("")) {
            user.setEmail(form.getEmail());
        }
        if(!form.getPhoneNumber().equals("")){
            user.setPhoneNumber(form.getPhoneNumber());
        }
        userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }
    public User getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }
    public User getUserByPhoneNumber(String phoneNumber) {
        return userRepository.findOneByPhoneNumber(phoneNumber);
    }


}
