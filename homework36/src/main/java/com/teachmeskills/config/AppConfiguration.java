package com.teachmeskills.config;

import com.teachmeskills.entities.Order;
import com.teachmeskills.entities.Person;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Properties;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Configuration
@ComponentScan(basePackages = "com.teachmeskills")
@EnableWebMvc
public class AppConfiguration {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public SessionFactory sessionFactory() {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql" +
                "://localhost:5432/movie");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.driver", "org.postgresql.Driver");
        properties.put("hibernate.hbm2ddl.auto", "create-drop");
        properties.put("hibernate.show_sql", "true");
        configuration.setProperties(properties);

        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Order.class);

        return configuration.buildSessionFactory();
    }
}
