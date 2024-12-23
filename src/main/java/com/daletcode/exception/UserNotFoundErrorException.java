package com.daletcode.exception;

public class UserNotFoundErrorException extends RuntimeException {

    public UserNotFoundErrorException(String message) {
        super(message);
    }
}
