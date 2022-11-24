package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.annotations.domain.Aggregate;
import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

import javax.naming.OperationNotSupportedException;
import java.util.UUID;

@Aggregate
class LeaveRequest {

    private LeaveRequestId requestId;

    private LeaveRequestType requestType;

    private final AuthorId authorId;

    private LeaveRequestPeriod period;

    private LeaveRequestStatus status;

    LeaveRequest(LeaveRequestType requestType, AuthorId authorId, LeaveRequestPeriod period) {
        this.requestId = new LeaveRequestId(UUID.randomUUID());
        this.requestType = requestType;
        this.authorId = authorId;
        this.period = period;
        this.status = LeaveRequestStatus.SUBMITTED;
    }

    public void markAsDeleted() {
        if (this.status != LeaveRequestStatus.SUBMITTED) {
            throw new IllegalArgumentException(); //todo
        }

        this.status = LeaveRequestStatus.DELETED;
    }

    
}
