package com.durys.jakub.companymanagement.domain.contracts.exception;

public class ContractPeriodEndDateIncorrectlyDefined extends RuntimeException {

    private static final String MSG = "Contract period end date incorrectly defined";

    public ContractPeriodEndDateIncorrectlyDefined() {
        super(MSG);
    }
}
