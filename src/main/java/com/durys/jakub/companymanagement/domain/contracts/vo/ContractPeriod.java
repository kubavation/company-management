package com.durys.jakub.companymanagement.domain.contracts.vo;


import java.time.LocalDate;
import java.util.Objects;

class ContractPeriod {

    private final ContractPeriodType type;
    private final LocalDate from;
    private final LocalDate to;

    ContractPeriod(ContractPeriodType type, LocalDate from, LocalDate to) {

        Objects.requireNonNull(type, "invalid period type param");
        Objects.requireNonNull(from, "invalid date from param");

        this.type = type;
        this.from = from;
        this.to = to;
    }
}
