package com.durys.jakub.companymanagement.domain.absences.leaverequests.domain.vo;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

import java.util.UUID;


public enum LeaveRequestStatus {
    SUBMITTED, DELETED, SEND_FOR_ACCEPTATION, ACCEPTED, CANCELLED, REJECTED
}
