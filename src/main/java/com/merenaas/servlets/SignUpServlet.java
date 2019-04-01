package com.merenaas.servlets;

import com.merenaas.forms.SignUpForm;
import com.merenaas.models.Basket;
import com.merenaas.models.User;
import com.merenaas.services.BasketService;
import com.merenaas.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {
    private UserService userService;
    private BasketService basketService;

    @Override
    public void init(ServletConfig config)  {
        ServletContext context = config.getServletContext();
        userService = (UserService) context.getAttribute("userService");
        basketService = (BasketService) context.getAttribute("basketService");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        try {
            request.getServletContext().getRequestDispatcher("/WEB-INF/view/signUp.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType ("text/html; charset=UTF-8");
        String login = request.getParameter("login");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("checkbox");
        if(userService.checkLogin(login) && userService.checkEmail(email) && userService.checkPassword(password)
                && userService.checkEmailForAvailability(email) && userService.checkLoginForAvailability(login)) {
            SignUpForm signUpForm = SignUpForm.builder()
                    .login(login)
                    .email(email)
                    .password(password)
                    .build();
            try {
                userService.signUp(signUpForm);
                HttpSession session = request.getSession(true);
                session.setAttribute("authorized", true);
                User user = userService.getUserByEmail(email);
                session.setAttribute("user", user);
                Long basketId = user.getBasket().getId();
                Basket basket = basketService.getBasketById(basketId);
                basket.getBooks().clear();
                session.setAttribute("basket", basket);
                if(checkbox!= null) {
                    Cookie loginCookie = new Cookie("login", login);
                    String secret = userService.getUUID(login).toString();
                    Cookie secretCookie = new Cookie("secret", secret);
                    response.addCookie(loginCookie);
                    response.addCookie(secretCookie);
                }
                response.sendRedirect("/profile");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        else {
            Map<String, Boolean> answers = new HashMap<>();
            Map<String, String> values = new HashMap<>();
            answers.put("chekLogin", userService.checkLogin(login));
            answers.put("chekEmail", userService.checkEmail(email));
            answers.put("chekPassword", userService.checkPassword(password));
            answers.put("checkLoginForAvailability", userService.checkLoginForAvailability(login));
            answers.put("checkEmailForAvailability", userService.checkEmailForAvailability(email));
            values.put("login", login);
            values.put("email", email);
            for(Map.Entry<String, Boolean> entry : answers.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            for(Map.Entry<String, String> entry : values.entrySet()) {
                request.setAttribute(entry.getKey(), entry.getValue());
            }
            request.getServletContext().getRequestDispatcher("/WEB-INF/view/signUp.jsp").forward(request, response);
        }
    }
}
