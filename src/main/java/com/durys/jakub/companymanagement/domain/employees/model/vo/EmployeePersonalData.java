package com.durys.jakub.companymanagement.domain.employees.model.vo;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;

@ValueObject
public class EmployeePersonalData {
    private final FirstName firstName;
    private final LastName lastName;
    private final Gender gender;

    public EmployeePersonalData(FirstName firstName, LastName lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

}