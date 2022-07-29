package com.durys.jakub.companymanagement.configuration.exception;

public class ConfigurationTypeAlreadyExistsException extends RuntimeException {

    private static final String MSG = "Configuration type '%s' already exists";

    public ConfigurationTypeAlreadyExistsException(String name) {
        super(String.format(MSG, name));
    }
}
