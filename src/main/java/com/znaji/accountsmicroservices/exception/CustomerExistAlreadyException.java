package com.znaji.accountsmicroservices.exception;

public class CustomerExistAlreadyException extends RuntimeException {
    public CustomerExistAlreadyException(String message) {
        super(message);
    }
}
