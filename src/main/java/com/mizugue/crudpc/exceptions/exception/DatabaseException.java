package com.mizugue.crudpc.exceptions.exception;

public class DatabaseException extends RuntimeException{

    public DatabaseException() {
    }

    public DatabaseException(String message) {
        super(message);
    }
}
