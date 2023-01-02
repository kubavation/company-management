package com.durys.jakub.companymanagement.domain.absences.leaverequests.exception;

public class RequestedQuantityExceedLeavePrivilegesException extends RuntimeException {


    public RequestedQuantityExceedLeavePrivilegesException() {
        super("Number of requested quantity exceed leave privileges");
    }
}
