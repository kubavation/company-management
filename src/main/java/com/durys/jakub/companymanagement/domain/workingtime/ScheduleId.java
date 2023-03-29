package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.EmployeeId;

import java.time.LocalDate;

public record ScheduleId(EmployeeId employeeId, LocalDate day) {

    public static ScheduleId from(EmployeeId employeeId, LocalDate day) {
        return new ScheduleId(employeeId, day);
    }

}
