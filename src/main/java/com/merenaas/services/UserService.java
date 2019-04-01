package com.merenaas.services;
import com.merenaas.forms.SignInForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;

import java.sql.SQLException;

public interface UserService {
    void signUp(SignUpForm signUpForm) throws SQLException;
    boolean signIn(SignInForm loginForm) throws SQLException;
    boolean checkPassword(String password);
    boolean checkEmail(String email);
    boolean checkLogin(String login);
    boolean checkLoginForAvailability(String login);
    boolean checkEmailForAvailability(String email);

    User getUserByLogin(String login);
    User getUserByEmail(String email);
    String getUUID(String login);
    void putToTheBasket(Long basketId, Long bookId);
}
