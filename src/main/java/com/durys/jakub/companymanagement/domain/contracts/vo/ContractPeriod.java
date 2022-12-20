package com.durys.jakub.companymanagement.domain.contracts.vo;


import com.durys.jakub.companymanagement.domain.contracts.exception.ContractPeriodEndDateIncorrectlyDefined;
import com.durys.jakub.companymanagement.domain.contracts.exception.ContractPeriodEndDateNotDefinedException;

import java.time.LocalDate;
import java.util.Objects;

class ContractPeriod {

    private final ContractPeriodType type;
    private final LocalDate from;
    private final LocalDate to;

    ContractPeriod(ContractPeriodType type, LocalDate from, LocalDate to) {

        Objects.requireNonNull(type, "invalid period type param");
        Objects.requireNonNull(from, "invalid date from param");

        validateContractPeriodByType(type, to);

        this.type = type;
        this.from = from;
        this.to = to;
    }

    private void validateContractPeriodByType(ContractPeriodType type, LocalDate to) {

        if (ContractPeriodType.FIXED_TERM.equals(type) && Objects.isNull(to)) {
            throw new ContractPeriodEndDateNotDefinedException();
        }

        if (ContractPeriodType.PERMANENT.equals(type) && Objects.nonNull(to)) {
            throw new ContractPeriodEndDateIncorrectlyDefined();
        }

    }
}
