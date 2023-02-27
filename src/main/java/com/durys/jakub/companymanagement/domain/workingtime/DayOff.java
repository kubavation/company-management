package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.List;

public final class DayOff extends Schedule {

    public DayOff(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull LocalDate day, @NonNull List<WorkDayEvent> events) {
        super(scheduleId, employeeId, day, events);
    }
}
