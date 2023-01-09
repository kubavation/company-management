package com.durys.jakub.companymanagement.domain.contracts.vo;


import java.time.LocalDate;
import java.util.Objects;

public abstract class ContractPeriod {

    private final LocalDate from;
    private final LocalDate to;

    protected ContractPeriod(LocalDate from, LocalDate to) {

        Objects.requireNonNull(from, "invalid date from param");

        this.from = from;
        this.to = to;
        validate();
    }

    protected abstract void validate();


    public LocalDate from() {
        return from;
    }

    public LocalDate to() {
        return to;
    }
}
