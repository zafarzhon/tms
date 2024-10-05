package com.teachmeskills.il_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BicycleException extends RuntimeException {
    private int code;
    private String message;
}
