package com.durys.jakub.companymanagement.absences.leaverequests.infrastructure;

import com.durys.jakub.companymanagement.absences.leaverequests.application.repository.impl.JpaLeaveRequestRepository;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LeaveRequestConfiguration {


    @Bean
    LeaveRequestRepository leaveRequestRepository() {
        return new JpaLeaveRequestRepository();
    }
}
