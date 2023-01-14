package com.durys.jakub.companymanagement.infrastructure.contracts;

import com.durys.jakub.companymanagement.domain.contracts.ContractRepository;
import com.durys.jakub.companymanagement.infrastructure.contracts.out.JdbcContractRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ContractsConfiguration {

    @Bean
    ContractRepository contractRepository() {
        return new JdbcContractRepository();
    }
}
