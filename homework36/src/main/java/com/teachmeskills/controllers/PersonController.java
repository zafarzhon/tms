package com.teachmeskills.controllers;

import com.teachmeskills.entities.Person;
import com.teachmeskills.services.DataBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final DataBaseService dbService;

    @GetMapping("/all")
    public String getAll() {
        List<Person> allPersons = dbService.getAllPersons();
        System.out.println("all persons");
        System.out.println(allPersons);
        return "";
    }

    @PostMapping("/create")
    public String create(Person person) {
        Person person1 = new Person();
        dbService.savePerson(person1);
        return "";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        dbService.deletePerson(id);
        return "";
    }

    @GetMapping
    public String getPersonById(@RequestParam("id") Long id) {
        Person personById = dbService.getPersonById(id);
        System.out.println("Get person by id:" + id);
        System.out.println(personById);
        return "";
    }
}
