package com.durys.jakub.companymanagement.domain.contracts.employment.trail;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;
import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriodType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TrailEmploymentContractPeriod extends ContractPeriod {

    class TrailEmploymentContractPeriodLongerThanThreeMonthsException extends RuntimeException {

        public TrailEmploymentContractPeriodLongerThanThreeMonthsException() {
            super("Period of trail employment contract cannot be longer than 3 months");
        }
    }

    public TrailEmploymentContractPeriod(LocalDate from, LocalDate to) {
        super(from, to);
    }

    @Override
    protected void validate() {

        Objects.requireNonNull(to(), "date to for trail employment contract must be provided");

        if (ChronoUnit.MONTHS.between(from(), to()) > 3) {
            throw new TrailEmploymentContractPeriodLongerThanThreeMonthsException();
        }
    }


}
