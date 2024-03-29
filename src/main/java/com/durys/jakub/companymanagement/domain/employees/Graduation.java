package com.durys.jakub.companymanagement.domain.employees;

import com.durys.jakub.companymanagement.domain.sharedkernel.util.RangeValidators;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Graduation {

    public enum Type {
        PRIMARY,
        SECONDARY,
        HIGHER
    }

    private final String schoolName;
    private final LocalDate from;
    private final LocalDate to;
    private final Type type;


    public Graduation(String schoolName, LocalDate from, LocalDate to, Type type) {

        Objects.requireNonNull(schoolName, "schoolName must be provided");
        Objects.requireNonNull(type, "type must be provided");

        RangeValidators.comparing(LocalDate.class)
                .validate(from, to);

        this.schoolName = schoolName;
        this.from = from;
        this.to = to;
        this.type = type;
    }
}
