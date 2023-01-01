package com.durys.jakub.companymanagement.domain.absences.leaverequests.exception;

public class RequestedHoursExceedLeavePrivilegesException extends RuntimeException {


    public RequestedHoursExceedLeavePrivilegesException() {
        super("Number of requested hour exceed leave privileges");
    }
}
