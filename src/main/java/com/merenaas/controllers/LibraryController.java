package com.merenaas.controllers;

import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/library")
    public String libraryPage(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "library";
    }
}
