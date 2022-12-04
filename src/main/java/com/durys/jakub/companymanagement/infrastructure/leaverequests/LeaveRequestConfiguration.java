package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeavePrivilegesRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
class LeaveRequestConfiguration {


    @Bean
    @Primary
    LeaveRequestRepository leaveRequestRepository(NamedParameterJdbcTemplate jdbcTemplate, LeaveRequestAggregateAssembler assembler) {
        return new JpaLeaveRequestRepository(jdbcTemplate, assembler);
    }

    @Bean
    LeaveRequestRepository testLeaveRequestRepository() {
        return new HashMapLeaveRequestRepository();
    }

    @Bean
    LeavePrivilegesRepository leavePrivilegesRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        return new JpaLeavePrivilegesRepository(jdbcTemplate);
    }
}
