package com.durys.jakub.companymanagement.infrastructure.employees.input.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDTO {

    private String departmentId;
    private EmployeePersonalDataDTO personalData;
    private List<GraduationDTO> graduations;
}
