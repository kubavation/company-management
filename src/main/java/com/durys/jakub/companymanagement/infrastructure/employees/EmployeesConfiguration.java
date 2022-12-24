package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.application.employees.EmployeesApplicationService;
import com.durys.jakub.companymanagement.commons.IdentityProvider;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class EmployeesConfiguration {

    @Bean
    @Primary
    public EmployeeRepository hashMapEmployeeRepository() {
        return new HashMapEmployeeRepository();
    }

    @Bean
    EmployeeRepository jdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcEmployeeRepository(jdbcTemplate);
    }

    @Bean
    public EmployeesApplicationService employeesApplicationService(EmployeeRepository employeeRepository, IdentityProvider identityProvider) {
        return new EmployeesApplicationService(employeeRepository, identityProvider);
    }
}
