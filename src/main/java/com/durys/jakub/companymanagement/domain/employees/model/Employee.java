package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;

@AggregateRoot
public class Employee implements Employable {

    private final EmployeeId employeeId;
    private PersonalData personalData;
    private Department department;

    public Employee(EmployeeId employeeId, PersonalData personalData, Department department) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.department = department;
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
