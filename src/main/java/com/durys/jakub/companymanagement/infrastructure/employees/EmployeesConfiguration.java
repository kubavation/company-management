package com.durys.jakub.companymanagement.infrastructure.employees;

import com.durys.jakub.companymanagement.domain.employees.model.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class EmployeesConfiguration {

    @Bean
    EmployeeRepository employeeRepository() {
        return new JpaEmployeeRepository();
    }
}
