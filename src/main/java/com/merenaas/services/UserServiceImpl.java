//package com.merenaas.services;
//
//import com.merenaas.forms.SignInForm;
//import com.merenaas.forms.SignUpForm;
//import com.merenaas.models.Basket;
//import com.merenaas.models.Book;
//import com.merenaas.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import com.merenaas.repositories.BasketRepository;
//import com.merenaas.repositories.BookRepository;
//import com.merenaas.repositories.UserRepository;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private BasketRepository basketRepository;
//    @Autowired
//    private BookRepository bookRepository;
//    @Autowired
//    private PasswordEncoder encoder;
//
//    public UserServiceImpl(UserRepository userRepository, BasketRepository basketRepository, BookRepository bookRepository, PasswordEncoder encoder) {
//        this.userRepository = userRepository;
//        this.basketRepository = basketRepository;
//        this.bookRepository = bookRepository;
//        this.encoder = encoder;
//
//    }
//
//    @Override
//    public void signUp(SignUpForm signUpForm) throws SQLException {
//        User user = User.builder()
//                .login(signUpForm.getLogin())
//                .email(signUpForm.getEmail())
//                .password(encoder.encode(signUpForm.getPassword()))
//                .uuid(UUID.randomUUID().toString())
//                .orders(new ArrayList<>())
//                .build();
//        Basket basket = Basket.builder()
//                .user(user)
//                .books(new ArrayList<>())
//                .build();
//        user.setBasket(basket);
//        basketRepository.save(basket);
//        userRepository.save(user);
//        basketRepository.addUserId(basket.getId(), user.getId());
//        userRepository.addBasketId(user.getId(), basket.getId());
//
//    }
//
//
//    @Override
//    public boolean signIn(SignInForm signInForm) {
//        System.out.println("мэйл: " + signInForm.getEmail());
//        Optional<User> userOptional = userRepository.findOneByEmail(signInForm.getEmail());
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            if (encoder.matches(signInForm.getPassword(), user.getPassword())) {
//                return true;
//            } else {
//                return false;
//            }
//        } else {
//            return false;
//
//        }
//    }
//
//    @Override
//    public boolean checkPassword(String password) {
//        Pattern pattern = Pattern.compile("^[a-z0-9_-]{6,18}$");
//        Matcher matcher = pattern.matcher(password);
//        return matcher.matches();
//    }
//
//    @Override
//    public boolean checkEmail(String email) {
//        Pattern pattern = Pattern.compile(".+@.+");
//        Matcher matcher = pattern.matcher(email);
//        return matcher.matches();
//    }
//
//    @Override
//    public boolean checkLogin(String login) {
//        Pattern pattern = Pattern.compile("^[a-z0-9_-]{3,16}$");
//        Matcher matcher = pattern.matcher(login);
//        return matcher.matches();
//    }
//
//    @Override
//    public boolean checkLoginForAvailability(String login) {
//        Optional<User> userOptional = userRepository.findOneByLogin(login);
//        if (userOptional.isPresent()) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public boolean checkEmailForAvailability(String email) {
//        Optional<User> userOptional = userRepository.findOneByEmail(email);
//        if (userOptional.isPresent()) {
//            return false;
//        }
//        return true;
//    }
//
//
//    @Override
//    public User getUserByEmail(String email) {
//        Optional<User> userOptional = userRepository.findOneByEmail(email);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        } else {
//            throw new IllegalArgumentException("Не найден User по Email");
//        }
//
//    }
//
//    @Override
//    public User getUserByLogin(String login) {
//        Optional<User> userOptional = userRepository.findOneByLogin(login);
//        if (userOptional.isPresent()) {
//            return userOptional.get();
//        } else {
//            throw new IllegalArgumentException("Не найден User по login");
//        }
//
//    }
//
//    @Override
//    public void putToTheBasket(Long basketId, Long bookId) {
//        Optional<Basket> basketOptional = basketRepository.findOne(basketId);
//        Optional<Book> bookOptional = bookRepository.findOne(bookId);
//        if (basketOptional.isPresent() && bookOptional.isPresent()) {
//            basketRepository.addProductToBasket(basketId, bookId);
//        }
//    }
//
//    @Override
//    public String getUUID(String login) {
//
//        Optional<User> user = userRepository.findOneByLogin(login);
//        if (user.isPresent()) {
//            return user.get().getUuid();
//        } else {
//            return null;
//        }
//    }
//
//}
