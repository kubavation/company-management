package com.durys.jakub.companymanagement.absences.leaverequests.domain.exception;

public class InvalidLeaveRequestPeriodException extends RuntimeException {

    public InvalidLeaveRequestPeriodException() {
        super("Invalid period of leave request");
    }
}
