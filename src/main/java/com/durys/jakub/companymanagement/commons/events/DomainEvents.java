package com.durys.jakub.companymanagement.commons.events;


import com.durys.jakub.companymanagement.commons.events.publisher.DomainEventPublisher;
import com.durys.jakub.companymanagement.infrastructure.shared.events.SpringEventPublisher;
import com.durys.jakub.companymanagement.infrastructure.shared.registry.SpringContext;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DomainEvents {

    public static DomainEventPublisher instance() {
        return SpringContext.getBean(SpringEventPublisher.class);
    }

}
