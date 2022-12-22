package com.durys.jakub.companymanagement.domain.employees.model;

import com.durys.jakub.companymanagement.commons.IdentityProvider;

import java.util.UUID;

public interface EmployeeRepository extends IdentityProvider<UUID> {
    <T extends Employable> T load(EmployeeId employeeId);

    void save(Employee employee);
}
