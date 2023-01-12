package com.durys.jakub.companymanagement.domain.contracts;

import com.durys.jakub.companymanagement.commons.domain.DomainEntity;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractData;

import java.time.LocalDate;
import java.util.Objects;

@DomainEntity
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

    void markAsClosedWith(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    boolean isClosed() {
        return Objects.isNull(dateTo);
    }
}
