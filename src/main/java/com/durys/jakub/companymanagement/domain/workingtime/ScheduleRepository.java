package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.Duration;
import java.time.LocalDate;

public interface ScheduleRepository {

    Schedule load(ScheduleId id);

    void save(Schedule schedule);

    Duration durationOfWorkDayEventInPeriod(WorkDayEventType type, EmployeeId employeeId, LocalDate from, LocalDate to);
}
