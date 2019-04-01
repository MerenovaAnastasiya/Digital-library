package com.merenaas.servlets;

import com.merenaas.forms.CheckoutForm;
import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.User;
import com.merenaas.services.BasketService;
import com.merenaas.services.OrderService;
import com.merenaas.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.time.LocalDate;


@WebServlet("/checOut")
public class СheckoutServlet extends HttpServlet {
    private OrderService orderService;


    @Override
    public void init(ServletConfig config)  {
        ServletContext context = config.getServletContext();
        orderService = (OrderService) context.getAttribute("orderService");
    }

    @Override
    public  void doPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        String address = request.getParameter("address");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String userFirstName = request.getParameter("first-name");
        String userLastName = request.getParameter("last-name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String comment = request.getParameter("comment");
        CheckoutForm checkoutForm = CheckoutForm.builder()
                .address(address)
                .date(date)
                .userFirstName(userFirstName)
                .userLastName(userLastName)
                .phone(phone)
                .email(email)
                .comment(comment)
                .build();
        User user = (User) request.getSession().getAttribute("user");
        try {
            orderService.checkOut(checkoutForm, user.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            Basket basket = (Basket) request.getSession().getAttribute("basket");
            basket.getBooks().clear();

            response.sendRedirect("/profile");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
