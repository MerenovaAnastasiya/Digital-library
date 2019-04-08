//package com.merenaas.servlets;
//
//import com.merenaas.models.Basket;
//import com.merenaas.models.Book;
//import com.merenaas.services.BasketService;
//import com.merenaas.services.UserService;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@WebServlet("/profile")
//public class ProfileServlet extends HttpServlet {
//    private BasketService basketService;
//
//    @Override
//    public void init(ServletConfig config) {
//        ServletContext context = config.getServletContext();
//        basketService = (BasketService) context.getAttribute("basketService");
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html; charset=UTF-8");
//        Basket basket = (Basket) request.getSession().getAttribute("basket");
//        Map<Book, Integer> userBooks = basketService.getUserBooks(basket);
//        request.getSession().setAttribute("userBooks", userBooks);
//        try {
//            request.getServletContext().getRequestDispatcher("/WEB-INF/view/profile.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
//    }
//}
