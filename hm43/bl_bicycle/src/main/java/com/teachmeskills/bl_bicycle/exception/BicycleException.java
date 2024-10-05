package com.teachmeskills.bl_bicycle.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BicycleException extends RuntimeException {
    private int code;
    private String message;
}
