package context;

import lombok.SneakyThrows;
import models.Basket;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import repositories.*;

import services.*;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class UserServiceListener {
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "12398aa98";
//    private static final String URL = "jdbc:postgresql://localhost:5432/postgres?characterEncoding=UTF-8";
//
//    @Override
//    @SneakyThrows
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//
//        Class.forName("org.postgresql.Driver");
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(URL);
//        dataSource.setUsername(USERNAME);
//        dataSource.setPassword(PASSWORD);
//        BasketRepository basketRepository = new BasketRepositoryJdbcTemplateImpl(dataSource);
//        UserRepository usersRepository = new UserRepositoryJdbcTemplateImpl(dataSource);
//        BookRepository bookRepository = new BookRepositoryJdbcTemplateImpl(dataSource);
//        OrderRepository orderRepository = new OrderRepositoryJdbcTemplate(dataSource);
////        UserService userService = new UserServiceImpl(usersRepository, basketRepository, bookRepository);
//        BookService bookService = new BookServiceImpl(bookRepository);
//        OrderService orderService = new OrderServiceImpl(orderRepository, basketRepository, usersRepository);
//
//        BasketService basketService = new BasketServiceImpl(basketRepository);
//        ServletContext context = servletContextEvent.getServletContext();
////        context.setAttribute("userService", userService);
//        context.setAttribute("bookService", bookService);
//        context.setAttribute("basketService", basketService);
//        context.setAttribute("orderService", orderService);
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }
}
