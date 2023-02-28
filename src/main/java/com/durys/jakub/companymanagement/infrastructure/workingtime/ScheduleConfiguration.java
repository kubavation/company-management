package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ScheduleConfiguration {

    @Bean
    ScheduleRepository scheduleRepository(JdbcTemplate jdbcTemplate) {
        return new JdbcScheduleRepository(jdbcTemplate);
    }
}
