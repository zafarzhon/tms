package com.teachmeskills.bl_bicycle.dto;

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
public class ErrorDto {
    private int code;
    private String message;
}
