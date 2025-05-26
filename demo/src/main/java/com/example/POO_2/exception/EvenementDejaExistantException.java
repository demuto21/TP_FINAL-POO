package com.example.POO_2.exception;

public class EvenementDejaExistantException extends RuntimeException {
    public EvenementDejaExistantException(String message) {
        super(message);
    }
}
