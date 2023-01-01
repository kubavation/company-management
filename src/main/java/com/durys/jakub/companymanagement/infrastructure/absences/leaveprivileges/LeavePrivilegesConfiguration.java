package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementsRepository;
import com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters.InMemoryLeaveEntitlementsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeavePrivilegesConfiguration {

    @Bean
    LeaveEntitlementsRepository inMemory() {
        return new InMemoryLeaveEntitlementsRepository();
    }

}
