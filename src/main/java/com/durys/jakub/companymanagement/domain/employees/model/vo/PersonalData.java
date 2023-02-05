package com.durys.jakub.companymanagement.domain.employees.model.vo;

import com.durys.jakub.companymanagement.commons.domain.ValueObject;
import lombok.AccessLevel;
import lombok.Getter;

import java.time.LocalDate;

@ValueObject
@Getter
public class PersonalData {
    private final FirstName firstName;
    private final LastName lastName;
    private final Gender gender;
    private final LocalDate birthdayDate;

    public PersonalData(FirstName firstName, LastName lastName, Gender gender, LocalDate birthdayDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdayDate = birthdayDate;
    }

    public PersonalData(String firstName, String lastName, String gender, LocalDate birthdayDate) {
        this(new FirstName(firstName), new LastName(lastName), Gender.valueOf(gender), birthdayDate);
    }

    public String name() {
        return "%s %s".formatted(lastName.value(), firstName.value());
    }

}
