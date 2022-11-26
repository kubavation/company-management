package com.durys.jakub.companymanagement.domain.absences.leaverequests.domain.exception;

public class InvalidLeaveRequestPeriodException extends RuntimeException {

    public InvalidLeaveRequestPeriodException() {
        super("Invalid period of leave request");
    }
}
