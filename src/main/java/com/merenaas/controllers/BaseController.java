package com.merenaas.controllers;

import com.merenaas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;


@Controller
public class BaseController {
    @Autowired
    private BookService bookService;

    public BaseController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/main")
    public String mainGet(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "main";
    }
//
//    @GetMapping(value = "/signIn")
//    public String mainGet(Model model) {
//        model.addAttribute("books", bookService.getAllBooks());
//        return "main";
//    }


//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) {
//        try {
//            request.setAttribute("books", bookService.getAllBooks());
//            request.getServletContext().getRequestDispatcher("/WEB-INF/view/main.jsp").forward(request, response);
//        } catch (ServletException e) {
//            throw new IllegalArgumentException("Не удаетс получить main.jsp");
//        } catch (IOException e) {
//            throw new IllegalArgumentException("Не удаетчя получить все книги через  bookService");
//        }
//    }

}
