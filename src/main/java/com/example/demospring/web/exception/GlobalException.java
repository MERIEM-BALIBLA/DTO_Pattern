package com.example.demospring.web.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String exception(MethodArgumentNotValidException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UserException.class)
    public String userException(UserException ex) {
        return ex.getMessage();
    }

}
