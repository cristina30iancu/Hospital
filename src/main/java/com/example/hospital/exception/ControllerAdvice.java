package com.example.hospital.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({Exception.class})
    public ResponseEntity exceptionHandler(Exception exception){
        return new ResponseEntity("Exception thrown!!!", HttpStatus.BAD_REQUEST);
    }
}
