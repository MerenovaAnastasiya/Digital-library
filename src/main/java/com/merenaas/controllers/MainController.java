package com.merenaas.controllers;

import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/main")
    public String mainPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "main";
    }
}
