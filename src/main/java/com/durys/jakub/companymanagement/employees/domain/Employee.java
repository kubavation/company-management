package com.durys.jakub.companymanagement.employees.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;

import java.util.UUID;

@Aggregate
public class Employee {
    private final EmployeeId employeeId;

    public Employee() {
        this.employeeId = new EmployeeId(UUID.randomUUID());
    }
}
