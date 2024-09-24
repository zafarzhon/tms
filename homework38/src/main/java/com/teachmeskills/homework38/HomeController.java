package com.teachmeskills.homework38;

import org.springframework.beans.factory.annotation.Value;
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
    @Value("${app.key}")
    private String profileName;
    @GetMapping
    public String home() {
        System.out.println(profileName);
        return "";
    }
}
