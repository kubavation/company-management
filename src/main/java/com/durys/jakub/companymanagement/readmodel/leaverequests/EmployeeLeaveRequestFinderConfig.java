package com.durys.jakub.companymanagement.readmodel.leaverequests;

import com.durys.jakub.companymanagement.readmodel.leaverequests.impl.JpaEmployeeLeaveRequestFinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
class EmployeeLeaveRequestFinderConfig {

    @Bean
    EmployeeLeaveRequestFinder employeeLeaveRequestFinder(JdbcTemplate jdbcTemplate) {
        return new JpaEmployeeLeaveRequestFinder(jdbcTemplate);
    }

}
