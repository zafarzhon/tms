package com.teachmeskills.il_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BicycleException extends RuntimeException {
    private int code;
    private String message;
}
