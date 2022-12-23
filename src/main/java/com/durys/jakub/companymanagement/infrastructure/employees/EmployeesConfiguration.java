package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.application.employees.EmployeesApplicationService;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class EmployeesConfiguration {

    @Bean
    public EmployeeRepository hashMapEmployeeRepository() {
        return new HashMapEmployeeRepository();
    }

    @Bean
    @Primary
    EmployeeRepository jdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcEmployeeRepository(jdbcTemplate);
    }

    @Bean
    public EmployeesApplicationService employeesApplicationService(EmployeeRepository employeeRepository) {
        return new EmployeesApplicationService(employeeRepository);
    }
}
