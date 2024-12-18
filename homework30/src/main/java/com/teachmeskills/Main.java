package com.teachmeskills;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zafarzhon
 * @link https://github.com/zafarzhon
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("app.xml");
        DbService bean = context.getBean(DbService.class);
    }
}