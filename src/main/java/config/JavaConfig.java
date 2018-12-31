package config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import repositories.*;
import services.*;

@PropertySource("classpath:db.properties")

public class JavaConfig {

    @Value("${db.url}")
    private String dbUrl;
    @Value("${db.user}")
    private String dbUser;
    @Value("${db.password}")
    private String dbPassword;
    @Value("${db.driverClassName}")
    private String dbDriverClassName;

    @Bean
    public BasketRepository basketRepository() {
        return new BasketRepositoryJdbcTemplateImpl(dataSource());
    }
    @Bean
    public BookRepository bookRepository() {
        return new BookRepositoryJdbcTemplateImpl(dataSource());
    }
    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryJdbcTemplateImpl(dataSource());
    }
    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepositoryJdbcTemplate(dataSource());
    }

    @Bean
    public BasketService basketService() {
        return new BasketServiceImpl(basketRepository());
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl(userRepository(), basketRepository(), bookRepository(), passwordEncoder());
    }

    @Bean
    public BookService bookService() {
        return new BookServiceImpl(bookRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(orderRepository(), basketRepository(), userRepository());
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dbUrl);
        dataSource.setPassword(dbPassword);
        dataSource.setUsername(dbUser);
        dataSource.setDriverClassName(dbDriverClassName);
        return dataSource;
    }

}
