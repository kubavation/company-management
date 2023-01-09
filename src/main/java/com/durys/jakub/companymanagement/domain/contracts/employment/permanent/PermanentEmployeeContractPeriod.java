package com.durys.jakub.companymanagement.domain.contracts.employment.permanent;

import com.durys.jakub.companymanagement.domain.contracts.vo.ContractPeriod;

import java.time.LocalDate;
import java.util.Objects;

public class PermanentEmployeeContractPeriod extends ContractPeriod {

    class ContractPeriodEndDateIncorrectlyDefined extends RuntimeException {

        public ContractPeriodEndDateIncorrectlyDefined() {
            super("Contract period end date incorrectly defined");
        }
    }

    public PermanentEmployeeContractPeriod(LocalDate from, LocalDate to) {
        super(from, to);
    }

    @Override
    protected void validate() {
        if (Objects.nonNull(to())) {
            throw new ContractPeriodEndDateIncorrectlyDefined();
        }
    }
}
