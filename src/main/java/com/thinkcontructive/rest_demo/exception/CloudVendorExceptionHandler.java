package com.thinkcontructive.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CloudVendorExceptionHandler {

    @ExceptionHandler(value = {CloudVendorNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorException(CloudVendorNotFoundException ex) {
        CloudVendorException cloudVendorException = new CloudVendorException(
                ex.getMessage(),
                ex.getCause(), //includes cause for practice purposes otherwise don't in production
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(cloudVendorException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex) {
        CloudVendorException response = new CloudVendorException(
                "An unexpected error occurred: " + ex.getMessage(),
                ex.getCause(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
