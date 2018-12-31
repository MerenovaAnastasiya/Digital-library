package services;
import forms.SignInForm;
import forms.SignUpForm;
import models.Basket;
import models.Book;
import models.User;

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
