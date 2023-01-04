package com.durys.jakub.companymanagement.commons.domain;

public interface DomainServicesRegistry {
    <T> T instanceOf(Class<T> clazz);
}
