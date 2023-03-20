package com.durys.jakub.companymanagement.infrastructure.workingtime.requests;

import com.durys.jakub.companymanagement.domain.workingtime.requests.WorkingTimeRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WorkingTimeRequestConfiguration {

    @Bean
    public WorkingTimeRequestRepository workingTimeRequestRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcWorkingTimeRequestRepository(jdbcTemplate);
    }
}
