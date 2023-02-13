package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;

public class WorkDay {
    private final WorkDayId id;
    private final EmployeeId employeeId;
    private final LocalDate day;

    public WorkDay(WorkDayId id, EmployeeId employeeId, LocalDate day) {
        this.id = id;
        this.employeeId = employeeId;
        this.day = day;
    }
}
