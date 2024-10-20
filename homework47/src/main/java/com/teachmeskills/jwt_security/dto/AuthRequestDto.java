package com.teachmeskills.jwt_security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Getter
@Setter
public class AuthRequestDto {
    private String username;
    private String password;
}
