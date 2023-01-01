package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.vo.EmployeePersonalData;

@AggregateRoot
public class Employee implements Employable {
    private final EmployeeId employeeId;
    private final EmployeePersonalData employeePersonalData;

    public Employee(EmployeeId employeeId, EmployeePersonalData employeePersonalData) {
        this.employeeId = employeeId;
        this.employeePersonalData = employeePersonalData;
    }

    @Override
    public EmployeeId employeeId() {
        return employeeId;
    }

    public EmployeePersonalData personalData() {
        return employeePersonalData;
    }

    public String name() {
        return String.format("%s %s", employeePersonalData.getLastName(), employeePersonalData.getFirstName());
    }
}
