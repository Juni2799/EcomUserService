package com.example.EcomUserService.exceptions;

public class InvalidCredentialException extends RuntimeException{
    public InvalidCredentialException() {
        super();
    }

    public InvalidCredentialException(String message) {
        super(message);
    }
}
