package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

public final class WorkDay extends Schedule {

    public WorkDay(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId,
                   @NonNull LocalDate day, @NonNull LocalTime from, @NonNull LocalTime to) {
        super(scheduleId, employeeId, WorkDayType.SCHEDULE, day, from, to);
    }
}
