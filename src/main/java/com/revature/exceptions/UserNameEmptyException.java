package com.revature.exceptions;

public class UserNameEmptyException extends RuntimeException {

    public UserNameEmptyException(String message){
        super(message);
    }

}
