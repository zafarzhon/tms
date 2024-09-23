package com.teachmeskills.services;

import com.teachmeskills.entities.Order;
import com.teachmeskills.entities.Person;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final SessionFactory sessionFactory;

    public void savePerson(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = new Order();
        Order order1 = new Order();
        Order order2 = new Order();
        person.addOrder(order);
        person.addOrder(order1);
        person.addOrder(order2);
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void saveOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    public void deletePerson(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.delete(person);
        transaction.commit();
        session.close();
    }

    public void deleteOrder(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        session.delete(order);
        transaction.commit();
        session.close();
    }

    public Person getPersonById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Person person = session.get(Person.class, id);
        transaction.commit();
        session.close();
        return person;
    }

    public Order getOrderById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.get(Order.class, id);
        transaction.commit();
        session.close();
        return order;
    }

    public List<Person> getAllPersons() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> persons = session.createQuery("from Person").list();
        transaction.commit();
        session.close();
        return persons;
    }

    public List<Order> getAllOrders() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Order> orders = session.createQuery("from Order").list();
        transaction.commit();
        session.close();
        return orders;
    }

    public List<Person> getPersonsByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> personsByName = session.createQuery("FROM Person where name = :name", Person.class)
                .setParameter("name", name).list();
        return personsByName;
    }

    public List<Person> getPersonsAgeLowerThan(Integer age) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Person> age1 =
                session.createQuery("from Person where age < :age", Person.class).setParameter(
                        "age", age).list();

        return age1;
    }

}
