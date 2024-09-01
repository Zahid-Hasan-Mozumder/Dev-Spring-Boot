package com.zhm.spring_boot.rest.restcrud.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class studentRestExceptionHandler {

    // add exception handling code here
    // add an exception handler
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(studentNotFoundException excep){

        // create a studentErrorResponse
        studentErrorResponse error = new studentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(excep.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return responseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // add an another exception handler
    @ExceptionHandler
    public ResponseEntity<studentErrorResponse> handleException(Exception excep){

        // create a studentErrorResponse
        studentErrorResponse error = new studentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(excep.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        // return responseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
