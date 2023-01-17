package com.durys.jakub.companymanagement.domain.employees.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
class Graduation {

    public enum Type {
        PRIMARY,
        SECONDARY,
        HIGHER
    }

    private String schoolName;
    private LocalDate from;
    private LocalDate to;
    private Type type;
}
