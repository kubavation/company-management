package com.durys.jakub.companymanagement.employees.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.annotations.domain.ValueObject;

import java.util.UUID;

@ValueObject
public class EmployeePersonalData {
    private final FirstName firstName;
    private LastName lastName;
    private final Gender gender;

    public EmployeePersonalData(FirstName firstName, LastName lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

}
