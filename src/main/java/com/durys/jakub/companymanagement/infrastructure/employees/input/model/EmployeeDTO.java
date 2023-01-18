package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthdayDate;
    private String departmentId;

    private List<GraduationDTO> graduations;
}
