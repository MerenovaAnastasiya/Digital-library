package com.merenaas.controllers;

//import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BaseController {
//    @Autowired
//    private BookService bookService;
//
//    public BaseController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping(value = "/main")
    public String mainGet(Model model) {
//        model.addAttribute("books", bookService.getAllBooks());
        return "main";
    }

    @GetMapping(value = "/signIn")
    public String signInGet() {
        return "signIn";
    }

    @GetMapping(value = "/signUp")
    public String signUpGet(Model model) {
//        model.addAllAttributes("user", )
        return "signUp";
    }

    @GetMapping(value = "/profile")
    public String profileGet() {
        return "profile";
    }


}
