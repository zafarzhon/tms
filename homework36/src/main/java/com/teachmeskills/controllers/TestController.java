package com.teachmeskills.controllers;

import com.teachmeskills.entities.Person;
import com.teachmeskills.services.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final SessionFactory sessionFactory;
    private final DataBaseService dataBaseService;

    @PostMapping("/create")
    public String create() {
        Person person = new Person();
        person.setName("John");
        person.setAge(21);
        Person person2 = new Person();
        person2.setName("Jane");
        person2.setAge(22);
        Person person3 = new Person();
        person3.setName("Joe");
        person3.setAge(23);
        dataBaseService.savePerson(person);
        dataBaseService.savePerson(person2);
        dataBaseService.savePerson(person3);
        return "";
    }

    @GetMapping("/persons")
    public String getPersonsByName(@RequestParam(name = "name") String name) {
        List<Person> personsByName = dataBaseService.getPersonsByName(name);

        System.out.println();

        return "";
    }

    @GetMapping("/persons/age")
    public String getPersonsLowerThan(@RequestParam(name = "lower_than") Integer age) {
        List<Person> personsByAgeLowerThan =
                dataBaseService.getPersonsAgeLowerThan(age);


        return "";
    }
}
