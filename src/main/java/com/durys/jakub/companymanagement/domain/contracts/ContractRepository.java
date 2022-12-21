package com.durys.jakub.companymanagement.domain.contracts;

public interface ContractRepository {

    Contract load(ContractId contractId);

    void save(Contract contract);
}
