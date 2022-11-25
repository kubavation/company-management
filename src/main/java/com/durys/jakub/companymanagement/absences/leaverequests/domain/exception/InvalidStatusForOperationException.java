package com.durys.jakub.companymanagement.absences.leaverequests.domain.exception;

public class InvalidStatusForOperationException extends RuntimeException {

    public InvalidStatusForOperationException() {
        super("Invalid status for this operation");
    }
}
