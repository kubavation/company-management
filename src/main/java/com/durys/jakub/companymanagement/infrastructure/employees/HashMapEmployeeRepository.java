package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;

import java.util.HashMap;

public class HashMapEmployeeRepository implements EmployeeRepository {

    private static final HashMap<EmployeeId, Employable> DB = new HashMap<>();

    @Override
    public <T extends Employable> T load(EmployeeId employeeId) {

        if (!DB.containsKey(employeeId)) {
            return null;
        }

        return (T) DB.get(employeeId);
    }

    @Override
    public void save(Employee employee) {
        DB.put(employee.getId(), employee);
    }
}
