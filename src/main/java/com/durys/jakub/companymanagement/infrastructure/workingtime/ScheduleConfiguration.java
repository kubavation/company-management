package com.durys.jakub.companymanagement.infrastructure.workingtime;

import com.durys.jakub.companymanagement.domain.workingtime.ScheduleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScheduleConfiguration {


    @Bean
    ScheduleRepository scheduleRepository() {
        return new JdbcScheduleRepository();
    }
}
