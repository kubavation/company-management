package com.durys.jakub.companymanagement.readmodel.employees;

import com.durys.jakub.companymanagement.readmodel.employees.impl.JdbcEmployeeFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class EmployeeFinderConfiguration {

    @Bean
    EmployeeFinder employeeFinder(JdbcTemplate jdbcTemplate) {
        return new JdbcEmployeeFinder(jdbcTemplate);
    }
}
