package com.teachmeskills.il_service.controller.exp;


import com.teachmeskills.il_service.dto.ErrorDto;
import com.teachmeskills.il_service.exception.BicycleException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(BicycleException.class)
    public ResponseEntity<ErrorDto> handleBicycleException(BicycleException e) {
        return ResponseEntity.badRequest().body(new ErrorDto(e.getCode(), e.getMessage()));
    }
}
