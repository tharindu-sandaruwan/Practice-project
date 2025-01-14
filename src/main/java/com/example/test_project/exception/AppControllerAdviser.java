package com.example.test_project.exception;

import com.example.test_project.controller.Response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppControllerAdviser {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EmployeeNotFoundException.class})
    public ErrorResponse ExceptionMessage(EmployeeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return errorResponse;
    }
}
