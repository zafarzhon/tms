package com.teachmeskills.jwt_security.service;

import com.teachmeskills.jwt_security.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
public interface UserService {
    List<User> findAll();

    User save(User user);

    User findByUsername(String username);

    UserDetailsService userDetailsService();

}
