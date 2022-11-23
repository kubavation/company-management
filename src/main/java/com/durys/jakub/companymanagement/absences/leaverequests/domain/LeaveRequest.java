package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

import java.util.UUID;

@Aggregate
class LeaveRequest {

    private LeaveRequestId requestId;

    private LeaveRequestType requestType;

    private AuthorId authorId;

    private LeaveRequestPeriodInfo period;

    LeaveRequest(LeaveRequestType requestType, AuthorId authorId, LeaveRequestPeriodInfo period) {
        this.requestId = new LeaveRequestId(UUID.randomUUID());
        this.requestType = requestType;
        this.authorId = authorId;
        this.period = period;
    }
}
