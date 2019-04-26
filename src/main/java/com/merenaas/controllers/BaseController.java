package com.merenaas.controllers;


import com.merenaas.api.itbook.BookLoader;
import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Set;


@Controller
public class BaseController {

    public BaseController(BookService bookService) {
    }

    @GetMapping(value = "/main")
    public String mainPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("books", Objects.requireNonNull(BookLoader.getAllBooks()));
        model.addAttribute("user", user);

        return "main";
    }

    @GetMapping(value = "/signIn")
    public String signInPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "signIn";
    }

    @GetMapping(value = "/signUp")
    public String signUpPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("signUpForm", new SignUpForm());
        model.addAttribute("user", user);
        return "signUp";
    }

    @GetMapping(value = "/profile")
    public String profilePage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        Basket basket = user.getBasket();
        Set<Book> bookSet = basket.getBooks();
        model.addAttribute("books", bookSet);
        model.addAttribute("checkoutForm", new CheckoutForm());
        return "profile";
    }

    @GetMapping(value = "/library")
    public String libraryPage(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("books", Objects.requireNonNull(BookLoader.getAllBooks()));
        model.addAttribute("user", user);
        return "library";
    }

    @GetMapping(value = "/book")
    public String bookPage(Model model, @RequestParam String isbn13, @AuthenticationPrincipal User user) {
        model.addAttribute("book", Objects.requireNonNull(BookLoader.getBookByIsbn13(isbn13)));
        model.addAttribute("user", user);
        return "book";
    }

}
