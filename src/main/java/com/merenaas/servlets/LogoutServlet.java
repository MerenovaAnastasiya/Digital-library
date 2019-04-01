package com.merenaas.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/logOut")
public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("authorized", false);
        Cookie[] cookies = request.getCookies();
        if(cookies!= null) {
            for(Cookie cookie: cookies) {
                if(cookie.getName().equals("login")) {
                    cookie.setMaxAge(1);
                    response.addCookie(cookie);
                }
                if(cookie.getName().equals("secret")){
                    cookie.setMaxAge(1);
                    response.addCookie(cookie);
                }
            }
        }
        response.sendRedirect("/main");
    }
}

