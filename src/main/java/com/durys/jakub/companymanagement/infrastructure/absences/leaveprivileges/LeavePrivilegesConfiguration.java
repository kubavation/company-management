package com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlementEmployeeRepository;
import com.durys.jakub.companymanagement.infrastructure.absences.leaveprivileges.out_adapters.InMemoryLeaveEntitlementEmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LeavePrivilegesConfiguration {

    @Bean
    LeaveEntitlementEmployeeRepository inMemory() {
        return new InMemoryLeaveEntitlementEmployeeRepository();
    }

}
