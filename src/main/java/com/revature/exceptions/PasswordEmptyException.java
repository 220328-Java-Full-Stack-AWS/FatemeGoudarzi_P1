package com.revature.exceptions;

public class PasswordEmptyException extends RuntimeException{
    public PasswordEmptyException(String message) {
        super(message);
    }
}
