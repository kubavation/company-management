package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainService;

@DomainService
public class ContractNumberProvider {

    ContractNumber generate(ContractType contractType) {
        return new ContractNumber("todo");
    }
}
