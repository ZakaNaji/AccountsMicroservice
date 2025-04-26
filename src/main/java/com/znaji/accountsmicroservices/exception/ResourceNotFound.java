package com.znaji.accountsmicroservices.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String module, String resource, String value) {
        super(String.format("%s resource of %s with value %s not found", resource, module, value));
    }
}
