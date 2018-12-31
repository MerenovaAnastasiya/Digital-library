package listeners;

import config.JavaConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.BasketService;
import services.BookService;
import services.OrderService;
import services.UserService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ComponentsListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = context.getBean(UserService.class);
        BookService bookService = context.getBean(BookService.class);
        BasketService basketService = context.getBean(BasketService.class);
        OrderService orderService = context.getBean(OrderService.class);
        sce.getServletContext().setAttribute("userService", userService);
        sce.getServletContext().setAttribute("bookService", bookService);
        sce.getServletContext().setAttribute("basketService", basketService);
        sce.getServletContext().setAttribute("orderService", orderService);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
