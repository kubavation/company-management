package com.durys.jakub.companymanagement.domain.contracts.vo;


import java.time.LocalDate;

class ContractPeriod {
    private final LocalDate from;
    private final LocalDate to;

    ContractPeriod(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }
}
