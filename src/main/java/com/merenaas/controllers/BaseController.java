package com.merenaas.controllers;


import com.merenaas.forms.SignUpForm;
import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BaseController {
    @Autowired
    private BookService bookService;

    public BaseController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/main")
    public String mainPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "main";
    }

    @GetMapping(value = "/signIn")
    public String signInPage() {
        return "signIn";
    }

    @GetMapping(value = "/signUp")
    public String signUpPage(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signUp";
    }

    @GetMapping(value = "/profile")
    public String profilePage() {
        return "profile";
    }

    @GetMapping(value = "/library")
    public String libraryPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "library";
    }

}
