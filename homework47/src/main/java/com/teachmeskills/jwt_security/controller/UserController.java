package com.teachmeskills.jwt_security.controller;

import com.teachmeskills.jwt_security.entity.User;
import com.teachmeskills.jwt_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/create")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }


}
