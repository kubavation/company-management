package com.durys.jakub.companymanagement.domain.contracts.vo;


import java.time.LocalDate;

class ContractPeriod {

    private final ContractPeriodType type;
    private final LocalDate from;
    private final LocalDate to;

    ContractPeriod(ContractPeriodType type, LocalDate from, LocalDate to) {
        this.type = type;
        this.from = from;
        this.to = to;
    }
}
