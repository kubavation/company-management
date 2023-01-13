package com.durys.jakub.companymanagement.domain.employees.model.vo;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;

@ValueObject
@Getter(AccessLevel.PUBLIC)
public class PersonalData {
    private final FirstName firstName;
    private final LastName lastName;
    private final Gender gender;

    public PersonalData(FirstName firstName, LastName lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public PersonalData(String firstName, String lastName, String gender) {
        this.firstName = new FirstName(firstName);
        this.lastName = new LastName(lastName);
        this.gender = Gender.valueOf(gender);
    }

}
