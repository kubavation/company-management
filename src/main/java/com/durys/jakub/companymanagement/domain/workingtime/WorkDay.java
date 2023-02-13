package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

public class WorkDay {
    private final WorkDayId id;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private List<WorkDayEvent> events;

    public WorkDay(WorkDayId id, EmployeeId employeeId, LocalDate day) {
        this.id = id;
        this.employeeId = employeeId;
        this.day = day;
        this.events = Collections.emptyList();
    }

    public void addPrivateExit(LocalTime from, LocalTime to) {
        events.add(new WorkDayEvent(from, to, WorkDayEventType.PRIVATE_EXIT));
    }
}
