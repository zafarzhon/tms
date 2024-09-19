package com.teachmeskills.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zafarzhon
 * @link <a href="https://github.com/zafarzhon">github</a>
 */
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ModelAndView emptyResultDataAccessHandle(Exception ex) {
        ModelAndView view = new ModelAndView("errors");
        view.addObject("error", "Invalid id");
        return view;
    }
}
