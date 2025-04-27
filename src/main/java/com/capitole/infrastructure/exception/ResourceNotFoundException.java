package com.capitole.infrastructure.exception;

/**
 * Custom exception for not found resources.
 */
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
