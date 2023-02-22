package com.durys.jakub.companymanagement.domain.workingtime.schedule;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;
import java.time.LocalTime;

public class WorkingSchedule {

    private final WorkingScheduleId workingScheduleId;
    private final EmployeeId employeeId;
    private final LocalDate day;
    private final LocalTime from;
    private final LocalTime to;

    public WorkingSchedule(WorkingScheduleId workingScheduleId, EmployeeId employeeId, LocalDate day, LocalTime from, LocalTime to) {
        this.workingScheduleId = workingScheduleId;
        this.employeeId = employeeId;
        this.day = day;
        this.from = from;
        this.to = to;
    }

}
