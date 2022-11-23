package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

import java.util.UUID;


public enum LeaveRequestStatus {
    CREATED, DELETED, SEND_FOR_ACCEPTATION, ACCEPTED
}
