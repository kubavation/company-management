package com.durys.jakub.companymanagement.domain.employees.model;

public interface EmployeeRepository {
    Employee load(EmployeeId employeeId);
}
