package com.teachmeskills;

import com.teachmeskills.config.AppConfig;
import com.teachmeskills.entities.Person;
import com.teachmeskills.entities.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public class Main {
    private static SessionFactory sessionFactory = new AppConfig().sessionFactory();
    public static void main(String[] args) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person john = new Person(UUID.randomUUID(),"John", 2000, Role.ADMIN);
        Person jane = new Person(UUID.randomUUID(),"Jane", 2000, Role.USER);
        session.save(john);
        session.save(jane);
        transaction.commit();
        session.close();

    }

}