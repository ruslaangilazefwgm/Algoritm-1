package com.example.algorithm1spring;

public class NullItemException extends RuntimeException {
    public NullItemException() {
    }

    public NullItemException(String message) {
        super(message);
    }
}
