package com.test.startswith.Prefixes.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ServerErrorException;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(Exception ex) {
        ErrorResponse errorResponse = new ServerErrorException("Resource not found", ex.getCause());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
