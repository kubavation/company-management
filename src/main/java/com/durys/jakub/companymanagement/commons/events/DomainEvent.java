package com.durys.jakub.companymanagement.commons.events;

import java.util.UUID;

public interface DomainEvent<T> {
    T getData();
    UUID getId();
}
