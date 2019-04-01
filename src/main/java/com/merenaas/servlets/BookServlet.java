package com.merenaas.servlets;

import com.merenaas.models.Basket;
import com.merenaas.models.Book;
import com.merenaas.models.User;
import com.merenaas.services.BasketService;
import com.merenaas.services.BookService;
import com.merenaas.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
    private BookService bookService;

    @Override
    public void init(ServletConfig config)  {
        ServletContext context = config.getServletContext();
        bookService = (BookService) context.getAttribute("bookService");

    }


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        Long id = Long.parseLong(request.getParameter("name"));
        Book book = bookService.getBook(id);
        if (book != null) {
            request.setAttribute("book", book);
            try {
                request.getServletContext().getRequestDispatcher("/WEB-INF/view/book.jsp").forward(request, response);

            } catch (ServletException e) {
               throw  new IllegalArgumentException("Не удается получить jsp file book.jsp");
            }
        }
    }
}
