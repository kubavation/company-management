package com.durys.jakub.companymanagement.readmodel.employees;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public class EmployeeWithPersonalData {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate birthdayDate;
    private String departmentId;
    private String departmentName;
    private String departmentShortcut;
    private String departmentPath;
}
