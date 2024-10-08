package com.teachmeskills.homework46.service.impl;

import com.teachmeskills.homework46.model.Person;
import com.teachmeskills.homework46.repository.PersonRepository;
import com.teachmeskills.homework46.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Person register(Person person) {
        if (personRepo.findByLogin(person.getLogin()) != null) {
            throw new RuntimeException("Login already exists");
        }
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_".concat(person.getRole().toUpperCase()));
        Person save = personRepo.save(person);
        return save;
    }

    @Override
    public Person findByLogin(String login) {
        Person byLogin = personRepo.findByLogin(login);
        return byLogin;
    }
}
