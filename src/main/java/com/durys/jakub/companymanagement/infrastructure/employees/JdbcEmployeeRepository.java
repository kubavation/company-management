package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.model.Employable;
import com.durys.jakub.companymanagement.domain.employees.model.Employee;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.UUID;

@AllArgsConstructor
public class JdbcEmployeeRepository implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public <T extends Employable> T load(EmployeeId employeeId) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public UUID nextId() {
        return UUID.randomUUID();
    }
}
