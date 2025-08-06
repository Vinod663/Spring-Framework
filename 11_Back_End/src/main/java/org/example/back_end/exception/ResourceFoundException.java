package org.example.back_end.exception;

public class ResourceFoundException extends RuntimeException {
    public ResourceFoundException(String message) {
        super(message); // Call the constructor of the superclass (RuntimeException) with the provided message
    }
}
