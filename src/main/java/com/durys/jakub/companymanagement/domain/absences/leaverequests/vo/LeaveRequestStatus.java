package com.durys.jakub.companymanagement.domain.absences.leaverequests.vo;


import java.util.Objects;

public enum LeaveRequestStatus {
    SUBMITTED, DELETED, SEND_FOR_ACCEPTATION, ACCEPTED, CANCELLED, REJECTED;


    public static LeaveRequestStatus fromName(String name) {

        Objects.requireNonNull(name, "Invalid name value");

        return LeaveRequestStatus.valueOf(name);
    }
}
