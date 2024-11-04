package com.teachmeskills.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/task")
    public String admin() {
        return "task";
    }

    @GetMapping("/order")
    public String noAccess() {
        return "order";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
