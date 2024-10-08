package com.teachmeskills.homework46.repository;

import com.teachmeskills.homework46.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

public interface PersonRepository extends JpaRepository<Person, UUID> {
    Person findByLogin(String login);
}
