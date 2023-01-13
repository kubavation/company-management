package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;

@AggregateRoot
public class Employee implements Employable {
    private final EmployeeId employeeId;
    private final PersonalData personalData;

    public Employee(EmployeeId employeeId, PersonalData personalData) {
        this.employeeId = employeeId;
        this.personalData = personalData;
    }

    @Override
    public EmployeeId employeeId() {
        return employeeId;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public String name() {
        return String.format("%s %s", personalData.getLastName(), personalData.getFirstName());
    }
}
