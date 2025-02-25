package com.mizugue.crudpc.exceptions.handler;

import com.mizugue.crudpc.exceptions.exception.ResourceNotFoundException;
import com.mizugue.crudpc.exceptions.structure.ApiError;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ApiError> entityNotFound(EntityNotFoundException e, HttpServletRequest request){
        ApiError error = new ApiError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        ApiError error = new ApiError(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }



}
