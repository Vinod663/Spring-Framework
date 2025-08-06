package org.example.back_end.exception;

import org.example.back_end.utill.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice // This annotation is used to handle exceptions globally across all controllers in the application.
public class GlobalExceptionHandler {
    // You can define exception handling methods here to handle specific exceptions
    // and return appropriate responses to the client.

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse> handleGenericException(Exception e) {
        return new ResponseEntity(
                new APIResponse(
                        500,
                        "default: "+e.getMessage(),//only for debugging purposes, in production you should not expose exception messages
                        null
                ), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> HandleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity(
                new APIResponse(
                        404,
                        e.getMessage(),
                        null
                ), HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(ResourceFoundException.class)
    public ResponseEntity<APIResponse> HandleResourceFoundException(Exception e) {
        return new ResponseEntity(
                new APIResponse(
                        409,
                        "Resource Found Already!: "+e.getMessage(),
                        null
                ), HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)//controller eke deepu @valid annoatation eken handle karanne exception throw karanna oone na amaruwen
    public ResponseEntity<APIResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity(
                new APIResponse(
                        400,
                        "Validation failed",
                        errors
                ),HttpStatus.BAD_REQUEST
        );

    }
}
