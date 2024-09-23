package com.teachmeskills.config;

import com.teachmeskills.entities.Person;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;


public class AppConfig {
    public SessionFactory sessionFactory(){
        Configuration cfg = new Configuration();
        Properties properties = new Properties();
        properties.put("hibernate.connection.url", "jdbc:postgresql" +
                "://localhost:5432/movie");
        properties.put("hibernate.connection.username", "postgres");
        properties.put("hibernate.connection.password", "root");
        properties.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto","update");
        cfg.addProperties(properties);

        cfg.addAnnotatedClass(Person.class);

        return cfg.buildSessionFactory();
    }
}
