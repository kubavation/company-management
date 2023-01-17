package com.durys.jakub.companymanagement.domain.employees.model;


import java.time.LocalDate;
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
        Objects.requireNonNull(from, "date from must be provided");
        Objects.requireNonNull(to, "date to must be provided");
        Objects.requireNonNull(type, "type must be provided");

        this.schoolName = schoolName;
        this.from = from;
        this.to = to;
        this.type = type;
    }
}
