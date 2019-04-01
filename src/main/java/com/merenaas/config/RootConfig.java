package com.merenaas.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan({"com.merenaas.services", "com.merenaas.repositories"})
@PropertySource("classpath:db.properties")
public class RootConfig {
    @Autowired
    private Environment env;

    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("db.url"));
        dataSource.setPassword(env.getProperty("db.password"));
        dataSource.setUsername(env.getProperty("db.user"));
        dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
        return dataSource;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
