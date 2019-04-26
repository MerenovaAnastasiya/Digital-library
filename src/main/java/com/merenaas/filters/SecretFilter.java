package com.merenaas.filters;

import com.merenaas.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//
//@WebFilter(urlPatterns = "/profile", description = "securityFilter")
//@Component("securityFilter")
//public class SecretFilter implements Filter {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        HttpSession session = request.getSession();
//        String login = "";
//        String secret = "";
//        if (session.getAttribute("secret") != null) {
//            secret = (String) session.getAttribute("secret");
//            System.out.println(secret);
//        }
//        if (session.getAttribute("login") != null) {
//            login = (String) session.getAttribute("login");
//            System.out.println(login);
//        }
//        if (userService.getUUID(login) != null) {
//            if (secret.equals(userService.getUUID(login))) {
//                filterChain.doFilter(request, response);
//            }
//        }
//    }
//}
