package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.employees.model.vo.PersonalData;
import com.durys.jakub.companymanagement.domain.sharedkernel.TenantId;
import com.durys.jakub.companymanagement.domain.sharedkernel.departments.Department;

import java.util.List;

@AggregateRoot
public class Employee implements Employable {

    private final EmployeeId employeeId;
    private PersonalData personalData;
    private final List<Graduation> graduations;

    private Department department;
    private TenantId tenantId;

    public Employee(EmployeeId employeeId, PersonalData personalData,
                    Department department, List<Graduation> graduations) {
        this.employeeId = employeeId;
        this.personalData = personalData;
        this.department = department;
        this.graduations = graduations;
    }

    @Override
    public EmployeeId employeeId() {
        return employeeId;
    }

    public PersonalData personalData() {
        return personalData;
    }

    public void graduate(Graduation graduation) {
        graduations.add(graduation);
    }

    public void changePersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    @Override
    public TenantId tenantId() {
        return tenantId;
    }

    public String name() {
        return String.format("%s %s", personalData.getLastName(), personalData.getFirstName());
    }




}
