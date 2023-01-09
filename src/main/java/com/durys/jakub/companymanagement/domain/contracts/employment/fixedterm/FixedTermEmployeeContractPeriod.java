package com.durys.jakub.companymanagement.domain.contracts.employment.fixedterm;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;

import java.time.LocalDate;
import java.util.Objects;

public class FixedTermEmployeeContractPeriod extends ContractPeriod {

    public FixedTermEmployeeContractPeriod(LocalDate from, LocalDate to) {
        super(from, to);
    }

    @Override
    protected void validate() {
        Objects.requireNonNull(super.to(), "date to for fixed term employment contract must be provided");
    }
}
