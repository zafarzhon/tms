package com.teachmeskills.homework46.service;

import com.teachmeskills.homework46.model.Person;
import com.teachmeskills.homework46.repository.PersonRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Component
@RequiredArgsConstructor
public class FillService {
    private final PasswordEncoder passwordEncoder;
    private final PersonRepository personRepo;

    @PostConstruct
    public void fill() {
        personRepo.deleteAll();
        Person person1 = new Person();
        person1.setLogin("admin");
        person1.setPassword(passwordEncoder.encode("root"));
        person1.setRole("ROLE_ADMIN");
        personRepo.save(person1);

        Person person2 = new Person();
        person2.setLogin("user");
        person2.setPassword(passwordEncoder.encode("root"));
        person2.setRole("ROLE_USER");
        personRepo.save(person2);
    }
}
