package com.example.Centric.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ExceptionsController {
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ResponseEntity<Object> missingParameterException(MissingServletRequestParameterException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Illegal parameter passed with error: "+e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> methodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Wrong Method used: "+e.getMessage(),
                HttpStatus.METHOD_NOT_ALLOWED,
                ZonedDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ResponseEntity<Object> httpClientException(HttpClientErrorException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Rest Template URI my not be reachable: "+e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> handleException(RuntimeException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Error occurred while performing this operation "+e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
