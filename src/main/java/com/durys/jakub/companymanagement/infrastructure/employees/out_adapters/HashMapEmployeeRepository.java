package com.durys.jakub.companymanagement.infrastructure.employees.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;

import java.util.HashMap;
import java.util.UUID;

public class HashMapEmployeeRepository implements EmployeeRepository {

    private static HashMap<EmployeeId, Employable> DB = new HashMap<>();

    @Override
    public <T extends Employable> T load(EmployeeId employeeId) {
        return (T) DB.get(employeeId);
    }
}