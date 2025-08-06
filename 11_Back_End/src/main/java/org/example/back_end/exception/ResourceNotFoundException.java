package org.example.back_end.exception;
//custom Exceptions
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message); // Call the constructor of the superclass (RuntimeException) with the provided message
    }
}
