package com.durys.jakub.companymanagement.shared.exception;

import java.util.function.Supplier;

public class EntityNotFoundException extends RuntimeException {

    private static final String MSG = "Entity not found (class: %s, id: %s)";
    private static final String MSG_PARAM = "Entity not found (class: %s, param: %s)";

    public EntityNotFoundException(Class<?> clazz, Object primaryKey) {
        super(String.format(MSG, clazz.getSimpleName(), primaryKey));
    }

    public EntityNotFoundException(Class<?> clazz, String param) {
        super(String.format(MSG, clazz.getSimpleName(), param));
    }

    public static Supplier<EntityNotFoundException> of(Class<?> clazz, Object primaryKey) {
        return () -> new EntityNotFoundException(clazz, primaryKey);
    }

    public static Supplier<EntityNotFoundException> of(Class<?> clazz, String param) {
        return () -> new EntityNotFoundException(clazz, param);
    }
}
