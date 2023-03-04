package com.durys.jakub.companymanagement.domain.workingtime;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

import java.time.LocalDate;

public record ScheduleId(EmployeeId employeeId, LocalDate day) {}
