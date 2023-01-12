package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;

import java.time.LocalDate;
import java.util.UUID;

class Annex {

    private final AnnexId annexId;
    private final ContractData contractData;
    private final LocalDate dateFrom;
    private LocalDate dateTo;

    Annex(AnnexId annexId,  LocalDate dateFrom, ContractData contractData) {
        this.annexId = annexId;
        this.contractData = contractData;
        this.dateFrom = dateFrom;
    }
}
