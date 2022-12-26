package com.durys.jakub.companymanagement.crud.configuration.model;


public interface CmConfigurationType<T> {
    T defaultValue();
    String name();
    String desc();
    T getValue();
    boolean isEnabled();
}
