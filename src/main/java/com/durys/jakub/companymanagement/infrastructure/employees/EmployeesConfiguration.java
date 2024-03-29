package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.EmployeeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class EmployeesConfiguration {

    @Bean
    @Primary
    @ConditionalOnProperty(prefix = "test-profile", name = "enabled", havingValue = "true")
    public EmployeeRepository hashMapEmployeeRepository() {
        return new HashMapEmployeeRepository();
    }

    @Bean
    EmployeeRepository jdbcEmployeeRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcEmployeeRepository(jdbcTemplate);
    }

}
