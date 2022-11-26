package com.durys.jakub.companymanagement.domain.absences.leaverequests.domain.exception;

public class OperationUnavailableException extends RuntimeException {

    public OperationUnavailableException() {
        super("Unavailable operation");
    }
}
