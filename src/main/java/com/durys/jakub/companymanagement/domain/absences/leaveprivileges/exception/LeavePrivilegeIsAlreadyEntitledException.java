package com.durys.jakub.companymanagement.domain.absences.leaveprivileges.exception;

public class LeavePrivilegeIsAlreadyEntitledException extends RuntimeException {

    public LeavePrivilegeIsAlreadyEntitledException() {
        super("Leave privilege is already entitled");
    }
}
