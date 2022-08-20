package com.pontolivre.gestaomembrosapi.exceptions.models;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
