package com.durys.jakub.companymanagement.commons.events.publisher;


import com.durys.jakub.companymanagement.commons.events.DomainEvent;

public interface DomainEventPublisher {
   void publish(DomainEvent event);
}
