package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;

import java.time.LocalDate;
import java.util.UUID;

class Annex {

    private final AnnexId annexId;
    private final ContractData contractData;
    private final LocalDate dateFrom;

    Annex(AnnexId annexId, ContractData contractData, LocalDate dateFrom) {
        this.annexId = annexId;
        this.contractData = contractData;
        this.dateFrom = dateFrom;
    }

     Annex(ContractData contractData, LocalDate dateFrom) {
        this.annexId = new AnnexId(UUID.randomUUID());
        this.contractData = contractData;
        this.dateFrom = dateFrom;
    }
}
