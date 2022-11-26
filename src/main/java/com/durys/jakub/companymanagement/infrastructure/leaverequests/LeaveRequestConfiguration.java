package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LeaveRequestConfiguration {


    @Bean
    LeaveRequestRepository leaveRequestRepository(LeaveRequestDAO leaveRequestDAO) {
        return new JpaLeaveRequestRepository(leaveRequestDAO);
    }
}
