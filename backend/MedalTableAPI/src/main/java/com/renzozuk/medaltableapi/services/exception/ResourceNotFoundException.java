package com.renzozuk.medaltableapi.services.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String name) {
        super("The requested " + name + " was not found.");
    }

    public ResourceNotFoundException(Class<?> clazz) {
        this(clazz.getSimpleName());
    }
}
