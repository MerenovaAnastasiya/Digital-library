//package com.merenaas.listeners;
//
//
//import com.merenaas.config.RootConfig;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import com.merenaas.services.BasketService;
//import com.merenaas.services.BookService;
//import com.merenaas.services.OrderService;
//import com.merenaas.services.UserService;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//
//public class ComponentsListener implements ServletContextListener {
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(RootConfig.class);
//        UserService userService = context.getBean(UserService.class);
//        BookService bookService = context.getBean(BookService.class);
//        BasketService basketService = context.getBean(BasketService.class);
//        OrderService orderService = context.getBean(OrderService.class);
//        sce.getServletContext().setAttribute("userService", userService);
//        sce.getServletContext().setAttribute("bookService", bookService);
//        sce.getServletContext().setAttribute("basketService", basketService);
//        sce.getServletContext().setAttribute("orderService", orderService);
//    }
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//
//    }
//}
