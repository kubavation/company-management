package com.durys.jakub.companymanagement.domain.absences.leaverequests.exception;

public class RequestedDaysExceedLeavePrivilegesException extends RuntimeException {


    public RequestedDaysExceedLeavePrivilegesException() {
        super("Number of requested days exceed leave privileges");
    }
}
