package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.Aggregate;
import com.durys.jakub.companymanagement.domain.employees.model.vo.EmployeePersonalData;

import java.util.UUID;

@Aggregate
public class Employee implements Employable {
    private final EmployeeId employeeId;
    private final EmployeePersonalData employeePersonalData;

    public Employee(EmployeePersonalData employeePersonalData) {
        this.employeeId = new EmployeeId(UUID.randomUUID());
        this.employeePersonalData = employeePersonalData;
    }

    @Override
    public EmployeeId getId() {
        return employeeId;
    }
}
