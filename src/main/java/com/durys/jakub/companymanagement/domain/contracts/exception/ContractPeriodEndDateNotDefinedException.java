package com.durys.jakub.companymanagement.domain.contracts.exception;

public class ContractPeriodEndDateNotDefinedException extends RuntimeException {

    private static final String MSG = "Contract period end date not specified";

    public ContractPeriodEndDateNotDefinedException() {
        super(MSG);
    }
}
