package com.durys.jakub.companymanagement.configuration.exception;

public class ConfigurationGroupNotExistsException extends RuntimeException {

    private static final String MSG = "Configuration group not exists";

    public ConfigurationGroupNotExistsException() {
        super(MSG);
    }
}