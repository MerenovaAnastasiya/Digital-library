package com.merenaas.services;

import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.User;
import com.merenaas.models.UserRoleEnum;
import com.merenaas.repositories.BasketRepository;
import com.merenaas.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    private PasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private BasketRepository basketRepository;

    @Autowired
    public UserService(UserRepository userRepository, BasketRepository basketRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.basketRepository = basketRepository;
        this.passwordEncoder = passwordEncoder;

    }

    public void signUp(SignUpForm registrationForm) {
        User user = new User();
        user.setEmail(registrationForm.getEmail());
        user.setLogin(registrationForm.getLogin());
        user.setPassword(passwordEncoder.encode(registrationForm.getPassword()));
        user.setUuid(UUID.randomUUID().toString());
        user.setOrders(new HashSet<>());

        Basket basket = new Basket();
        basket.setUser(user);
        basket.setBooks(new HashSet<>());
        user.setBasket(basket);
        basketRepository.save(basket);
        userRepository.save(user);
        basketRepository.setUserToBasket(user, basket.getId());
        userRepository.setBasketToUser(basket, user.getId());

    }

//    public void saveUser(User user, Map<String, String> form) {
//        Set<String> roles = Arrays.stream(UserRoleEnum.values())
//                .map(UserRoleEnum::name)
//                .collect(Collectors.toSet());
//        user.getRoles().clear();
//        for (String key : form.keySet()) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Roles.valueOf(key));
//            }
//        }
//        userRepository.save(user);
//    }


    //    @Override
//    public void signUp(SignUpForm signUpForm) throws SQLException {
//        User user = User.builder()
//                .login(signUpForm.getLogin())
//                .email(signUpForm.getEmail())
//                .password(encoder.encode(signUpForm.getPassword()))
//                .uuid(UUID.randomUUID().toString())
//                .orders(new HashSet<>())
//                .build();
//        Basket basket = Basket.builder()
//                .user(user)
//                .books(new HashSet<>())
//                .build();
//        user.setBasket(basket);
//        basketRepository.save(basket);
//        userRepository.save(user);
//        basketRepository.addUserId(basket.getId(), user.getId());
//        userRepository.addBasketId(user.getId(), basket.getId());
//
//    }


//    void signUp(SignUpForm signUpForm) throws SQLException;
//    boolean signIn(SignInForm loginForm) throws SQLException;
//    boolean checkPassword(String password);
//    boolean checkEmail(String email);
//    boolean checkLogin(String login);
//    boolean checkLoginForAvailability(String login);
//    boolean checkEmailForAvailability(String email);
//
//    User getUserByLogin(String login);
//    User getUserByEmail(String email);
//    String getUUID(String login);
//    void putToTheBasket(Long basketId, Long bookId);
}
