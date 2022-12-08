package com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception;

public class InvalidLeavePrivilegesPeriodException extends RuntimeException {


    public InvalidLeavePrivilegesPeriodException() {
        super("Invalid period of leave privileges");
    }
}
