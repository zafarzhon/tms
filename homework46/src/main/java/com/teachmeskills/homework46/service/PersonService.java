package com.teachmeskills.homework46.service;

import com.teachmeskills.homework46.model.Person;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface PersonService {
    public Person register(Person user);

    public Person findByLogin(String login);
}
