package com.durys.jakub.companymanagement.shared.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final String message = "Entity not found (class: %s, id: %s)";

    public EntityNotFoundException(Class<?> clazz, Object primaryKey) {
        super(String.format(message, clazz.getSimpleName(), primaryKey));
    }
}
