package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;

import java.util.UUID;

@DomainService
public class ContractNumberProvider {

    ContractNumber generate(ContractType contractType) {
        return new ContractNumber(UUID.randomUUID().toString()); //todo explore domain
    }
}
