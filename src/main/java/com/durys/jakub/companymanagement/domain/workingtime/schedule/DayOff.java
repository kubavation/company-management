package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import lombok.NonNull;

import java.time.LocalDate;

public final class DayOff extends Schedule {

    public DayOff(@NonNull ScheduleId scheduleId, @NonNull EmployeeId employeeId, @NonNull LocalDate day) {
        super(scheduleId, employeeId, WorkDayType.DAY_OFF, day);
    }
}
