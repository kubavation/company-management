package com.durys.jakub.companymanagement.domain.employees.model.vo;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;

@ValueObject
@Getter(AccessLevel.PUBLIC)
public class EmployeePersonalData {
    private final FirstName firstName;
    private final LastName lastName;
    private final Gender gender;

    public EmployeePersonalData(FirstName firstName, LastName lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public EmployeePersonalData(String firstName, String lastName, String gender) {
        this.firstName = new FirstName(firstName);
        this.lastName = new LastName(lastName);
        this.gender = Gender.valueOf(gender);
    }

}
