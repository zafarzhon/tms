package com.teachmeskills.jwt_security.controller;

import com.teachmeskills.jwt_security.dto.AuthRequestDto;
import com.teachmeskills.jwt_security.dto.AuthResponseDto;
import com.teachmeskills.jwt_security.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestController
@RequestMapping("/rest")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public AuthResponseDto auth(@RequestBody AuthRequestDto authRequestDto) {
        return authService.auth(authRequestDto);
    }


    @PostMapping("/protect")
    public String protect() {
        return "protected";
    }
}
