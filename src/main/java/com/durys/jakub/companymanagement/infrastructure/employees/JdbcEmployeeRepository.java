package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.Employable;
import com.durys.jakub.companymanagement.domain.employees.Employee;
import com.durys.jakub.companymanagement.domain.employees.EmployeeId;
import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

@AllArgsConstructor
public class JdbcEmployeeRepository implements EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public <T extends Employable> T load(EmployeeId employeeId) {
       // jdbcTemplate.queryForObject("SELECT * FROM EM", EmployeeEntity.class);
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

}
