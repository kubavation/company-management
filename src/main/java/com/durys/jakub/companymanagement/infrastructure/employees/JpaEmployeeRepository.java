package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;

public class JpaEmployeeRepository implements EmployeeRepository {


    @Override
    public <T extends Employable> T load(EmployeeId employeeId) {
        return null;
    }
}
