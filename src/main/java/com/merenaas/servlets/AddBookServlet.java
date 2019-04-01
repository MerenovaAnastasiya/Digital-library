package com.merenaas.servlets;


import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import com.merenaas.services.BasketService;
import com.merenaas.services.BookService;
import com.merenaas.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
    UserService userService;
    BookService bookService;
    BasketService basketService;

    @Override
    public void init(ServletConfig config) {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
        bookService = (BookService) context.getAttribute("bookService");
        basketService = (BasketService) context.getAttribute("basketService");

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Optional<Object> optionalUser = Optional.of(request.getSession().getAttribute("user"));
        Long bookId = Long.parseLong(request.getParameter("book-id"));
        System.out.println(bookId);
        if(optionalUser.isPresent()) {
            User user = (User) optionalUser.get();
            Long basketId = user.getBasket().getId();
            userService.putToTheBasket(basketId, bookId);
            Book book = bookService.getBook(bookId);
            Basket basket = (Basket)request.getSession().getAttribute("basket");
            basket.getBooks().add(book);
        }
        response.sendRedirect("book?name="+bookId);
    }
}

