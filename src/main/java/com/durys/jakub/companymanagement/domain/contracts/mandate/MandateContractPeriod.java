package com.durys.jakub.companymanagement.domain.contracts.mandate;

import com.durys.jakub.companymanagement.domain.contracts.exception.InvalidContractPeriodException;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;

import java.time.LocalDate;
import java.util.Objects;

public class MandateContractPeriod extends ContractPeriod {

    public MandateContractPeriod(LocalDate from, LocalDate to) {
        super(from, to);
    }

    @Override
    protected void validate() {

        Objects.requireNonNull(to(), "date to for mandate contract must be provided");

        if (!to().isAfter(from())) {
            throw new InvalidContractPeriodException();
        }

    }


}
