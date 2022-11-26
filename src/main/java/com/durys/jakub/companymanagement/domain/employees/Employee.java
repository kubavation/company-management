package com.durys.jakub.companymanagement.domain.employees;

import com.durys.jakub.companymanagement.commons.domain.Aggregate;

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
