package com.durys.jakub.companymanagement.domain.employees.model;

public interface EmployeeRepository {
    <T extends Employable> T load(EmployeeId employeeId);

    void save(Employee employee);
}
