package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GraduationDTO {
    private String schoolName;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String type;
}
