package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public final class WorkDay extends Schedule {

    public WorkDay(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId,
                   @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to, @NonNull List<WorkDayEvent> events) {
        super(scheduleId, employeeId, day, from, to, events);
    }
}
