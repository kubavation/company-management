package com.durys.jakub.companymanagement.commons.events;

public interface DomainEventPublisher {
    <T> void publish(DomainEvent<T> event);
}
