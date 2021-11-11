package com.epam.training.microservices.taxicustomerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ClassNotFoundAdvice {
    @ExceptionHandler(CustomerNotFoundNotException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String departmentNotFoundHandler(CustomerNotFoundNotException customerNotFoundNotException) {
        return customerNotFoundNotException.getMessage();
    }
}
