package com.mizugue.crudpc.exceptions.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
    }
}
