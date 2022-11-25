package com.durys.jakub.companymanagement.absences.leaverequests.infrastructure;

import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
class LeaveRequestConfiguration {


    @Bean
    LeaveRequestRepository leaveRequestRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        return new JpaLeaveRequestRepository(jdbcTemplate);
    }
}
