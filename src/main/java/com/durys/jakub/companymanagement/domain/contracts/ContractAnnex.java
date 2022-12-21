package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;

public class ContractAnnex {

    private final AnnexId annexId;
    private final ContractId contractId;
    private final ContractData contractData;

    public ContractAnnex(AnnexId annexId, ContractData contractData, ContractId contractId) {
        this.annexId = annexId;
        this.contractData = contractData;
        this.contractId = contractId;
    }
}
