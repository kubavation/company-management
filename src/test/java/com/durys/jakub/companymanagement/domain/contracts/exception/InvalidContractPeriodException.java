package com.durys.jakub.companymanagement.domain.contracts.exception;

public class InvalidContractPeriodException extends RuntimeException {

    private static final String MSG = "Invalid contract period dates";

    public InvalidContractPeriodException() {
        super(MSG);
    }
}
