package com.durys.jakub.companymanagement.domain.absences.leaverequests.exception;

public class InvalidStatusForOperationException extends RuntimeException {

    public InvalidStatusForOperationException() {
        super("Invalid status for this operation");
    }
}
