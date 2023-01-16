package com.durys.jakub.companymanagement.domain.contracts.event;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

public record EmploymentContractCreatedEvent(EmployeeId employeeId) implements DomainEvent {
}
