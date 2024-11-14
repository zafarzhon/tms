package com.teachmeskills.controllers;

import com.teachmeskills.entities.Order;
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
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final DataBaseService dbService;

    @GetMapping("/all")
    public String getAll() {
        List<Order> allOrders = dbService.getAllOrders();
        System.out.println("all orders");
        System.out.println(allOrders);
        return "";
    }

    @PostMapping("/create")
    public String create(Order order) {
        Person person = new Person();
        dbService.savePerson(person);
        Order order1 = new Order();
        dbService.saveOrder(order1);
        return "";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        dbService.deleteOrder(id);
        return "";
    }

    @GetMapping
    public String getOrderById(@RequestParam("id") Long id) {
        Order orderById = dbService.getOrderById(id);
        System.out.println("Get order by id:" + id);
        System.out.println(orderById);
        return "";
    }
}
