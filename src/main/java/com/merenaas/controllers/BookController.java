package com.merenaas.controllers;

import com.merenaas.api.itbook.BookLoader;
import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import com.merenaas.services.BasketService;
import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BasketService basketService;
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/addBook")
    public String addBook(Model model, @AuthenticationPrincipal User user, @RequestParam String isbn13) {
        model.addAttribute("user", user);
        Book book = BookLoader.getBookByIsbn13(isbn13);
        bookService.saveBook(book);
        Basket basket = user.getBasket();
        basketService.addBookToBasket(bookService.getBook(book.getId()), basket);
        return "redirect:/book/?isbn13="+isbn13;
    }
}
