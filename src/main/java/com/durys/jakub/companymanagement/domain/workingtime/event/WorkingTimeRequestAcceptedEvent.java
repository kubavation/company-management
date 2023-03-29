package com.durys.jakub.companymanagement.domain.workingtime.event;

import com.durys.jakub.companymanagement.commons.events.DomainEvent;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.workingtime.ScheduleId;
import com.durys.jakub.companymanagement.domain.workingtime.requests.vo.WorkingTimeRequestPeriod;
import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestType;

import java.time.LocalDate;
import java.time.LocalTime;


public record WorkingTimeRequestAcceptedEvent(ScheduleId scheduleId, WorkingTimeRequestType type,
                                              WorkingTimeRequestPeriod period) implements DomainEvent {

    public EmployeeId employeeId() {
        return scheduleId.employeeId();
    }

    public LocalDate atDay() {
        return scheduleId.day();
    }

    public LocalTime from() {
        return period.from();
    }

    public LocalTime to() {
        return period.to();
    }
}
