package com.durys.jakub.companymanagement.employees.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;

import java.util.UUID;

@Aggregate
public class Employee {
    private final EmployeeId employeeId;
    private final EmployeePersonalData employeePersonalData;

    public Employee(EmployeePersonalData employeePersonalData) {
        this.employeeId = new EmployeeId(UUID.randomUUID());
        this.employeePersonalData = employeePersonalData;
    }
}
