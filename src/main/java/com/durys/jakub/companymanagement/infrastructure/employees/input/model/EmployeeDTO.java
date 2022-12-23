package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    private String gender;
}
