package com.durys.jakub.companymanagement.domain.contracts.event;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;

public record EmploymentContractCreatedEvent(String employeeId) implements DomainEvent {
}
