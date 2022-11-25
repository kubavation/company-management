package com.durys.jakub.companymanagement.commons.events;

import java.util.UUID;

public interface DomainEventPublisher {
    <T> void publish(DomainEvent<T> event);
}
