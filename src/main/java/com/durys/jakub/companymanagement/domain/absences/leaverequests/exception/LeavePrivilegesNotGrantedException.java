package com.durys.jakub.companymanagement.domain.absences.leaverequests.exception;

public class LeavePrivilegesNotGrantedException extends RuntimeException {


    public LeavePrivilegesNotGrantedException() {
        super("Leave privileges not granted");
    }
}
