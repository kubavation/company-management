package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;

import java.util.UUID;

class Annex {

    private final AnnexId annexId;
    private final ContractId contractId;
    private final ContractData contractData;

    Annex(AnnexId annexId, ContractData contractData, ContractId contractId) {
        this.annexId = annexId;
        this.contractData = contractData;
        this.contractId = contractId;
    }

     Annex(ContractData contractData, ContractId contractId) {
        this.annexId = new AnnexId(UUID.randomUUID());
        this.contractData = contractData;
        this.contractId = contractId;
    }
}
