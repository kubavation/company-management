package com.durys.jakub.companymanagement.employees.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.annotations.domain.ValueObject;

import java.util.UUID;

@ValueObject
public class EmployeePersonalData {
    private final FirstName firstName;
    private final LastName lastName;

    public EmployeePersonalData(FirstName firstName, LastName lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
