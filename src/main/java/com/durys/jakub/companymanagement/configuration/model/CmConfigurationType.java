package com.durys.jakub.companymanagement.configuration.model;


public interface CmConfigurationType<T> {
    T defaultValue();
    String name();
    String desc();
    String declaringClassName();
}
