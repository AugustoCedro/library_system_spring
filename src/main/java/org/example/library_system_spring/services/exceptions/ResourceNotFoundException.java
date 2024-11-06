package org.example.library_system_spring.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id) {
        super("Resource Not Found. Id " + id);
    }
}
