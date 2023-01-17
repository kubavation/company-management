package com.durys.jakub.companymanagement.domain.employees.model;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
class Graduation {
    private String schoolName;
    private LocalDate from;
    private LocalDate to;
}
