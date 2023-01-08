package com.durys.jakub.companymanagement.domain.contracts.vo;


import com.durys.jakub.companymanagement.domain.contracts.exception.ContractPeriodEndDateIncorrectlyDefined;
import com.durys.jakub.companymanagement.domain.contracts.exception.ContractPeriodEndDateNotDefinedException;
import com.durys.jakub.companymanagement.domain.contracts.exception.InvalidContractPeriodException;

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

    abstract void validate();

//    private void validateContractPeriodByType(ContractPeriodType type, LocalDate from, LocalDate to) {
//
//        if (ContractPeriodType.FIXED_TERM.equals(type)) {
//
//            if (Objects.isNull(to)) {
//                throw new ContractPeriodEndDateNotDefinedException();
//            }
//
//            if (!to.isAfter(from)) {
//                throw new InvalidContractPeriodException();
//            }
//        }
//
//        if (ContractPeriodType.PERMANENT.equals(type) && Objects.nonNull(to)) {
//            throw new ContractPeriodEndDateIncorrectlyDefined();
//        }
//
//    }
}
