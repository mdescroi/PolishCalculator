package org.example;

public class NotEnoughOperandsOnStackException extends RuntimeException {
    public NotEnoughOperandsOnStackException(String message) {
        super(message);
    }
}
