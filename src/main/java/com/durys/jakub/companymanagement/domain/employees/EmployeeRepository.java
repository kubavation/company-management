package com.durys.jakub.companymanagement.domain.employees;

public interface EmployeeRepository {

    <T extends Employable> T load(EmployeeId employeeId);

    void save(Employee employee);
}
