package com.durys.jakub.companymanagement.domain.workingtime.event;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;

import java.time.LocalDate;


public record WorkingTimeRequestAcceptedEvent(EmployeeId employeeId, WorkingTimeRequestType type,
                                              LocalDate atDay, WorkingTimeRequestPeriod period) implements DomainEvent {
}
