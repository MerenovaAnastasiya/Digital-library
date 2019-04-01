package com.merenaas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@Import({RootConfig.class})
@ComponentScan(basePackages = {"com.merenaas.controllers"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver() {
        ViewResolver viewResolver = new InternalResourceViewResolver();
        ((InternalResourceViewResolver) viewResolver).setViewClass(JstlView.class);
        ((InternalResourceViewResolver) viewResolver).setPrefix("/WEB-INF/views/");
        ((InternalResourceViewResolver) viewResolver).setSuffix(".jsp");
        return viewResolver;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").
                addResourceLocations("/static/");
    }
}
