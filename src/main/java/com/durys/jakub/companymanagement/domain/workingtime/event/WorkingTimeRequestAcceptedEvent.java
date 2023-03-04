package com.durys.jakub.companymanagement.domain.workingtime.event;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;


public record WorkingTimeRequestAcceptedEvent(ScheduleId scheduleId, WorkingTimeRequestType type,
                                              WorkingTimeRequestPeriod period) implements DomainEvent {
}
