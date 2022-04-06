package com.durys.jakub.companymanagement.shared.exception;

public class EntityNotFoundException extends RuntimeException {

    private static final String MSG = "Entity not found (class: %s, id: %s)";

    public EntityNotFoundException(Class<?> clazz, Object primaryKey) {
        super(String.format(MSG, clazz.getSimpleName(), primaryKey));
    }
}
