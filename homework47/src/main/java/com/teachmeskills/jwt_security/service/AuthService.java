package com.teachmeskills.jwt_security.service;

import com.teachmeskills.jwt_security.dto.AuthRequestDto;
import com.teachmeskills.jwt_security.dto.AuthResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthResponseDto auth(AuthRequestDto authRequestDto) {
        UserDetails userDetails = userService.userDetailsService().loadUserByUsername(authRequestDto.getUsername());
        System.out.println();
        if (!passwordEncoder.matches(authRequestDto.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return new AuthResponseDto(tokenService.createToken(userDetails));
    }
}
