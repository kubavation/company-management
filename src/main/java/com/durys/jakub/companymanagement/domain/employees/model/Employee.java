package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.employees.model.vo.Structure;

@AggregateRoot
public class Employee implements Employable {

    private final EmployeeId employeeId;
    private final PersonalData personalData;
    private Structure structure;

    public Employee(EmployeeId employeeId, PersonalData personalData, Structure structure) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.structure = structure;
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
