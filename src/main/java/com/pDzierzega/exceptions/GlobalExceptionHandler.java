package com.pDzierzega.exceptions;

import com.pDzierzega.exceptions.authentication.UserAlreadyExistAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistAuthenticationException.class)
    @ResponseBody
    public ResponseEntity<String> handleAuthorNotFoundException(UserAlreadyExistAuthenticationException e) {
        return new ResponseEntity<>(String.format("Author with uuid: %s doesn't exist", e.getUsername()),
                HttpStatus.BAD_REQUEST);
    }
}
