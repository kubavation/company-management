package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Aggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Aggregate
public class LeaveRequest {

    private LeaveRequestId requestId;

    private LeaveRequestType requestType;

    private final AuthorId authorId;

    private AcceptantId acceptantId;

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
        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.DELETED;
    }

    public void sendToAcceptant(AcceptantId acceptantId) {
        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.SEND_FOR_ACCEPTATION;
        this.acceptantId = acceptantId;
    }

    public void markAsCancelled() {
        if (status == LeaveRequestStatus.DELETED) {
            throw new InvalidStatusForOperationException();
        }

        if (LocalDateTime.now().isAfter(period.getDateFrom())) {
            throw new OperationUnavailableException();
        }

        this.status = LeaveRequestStatus.CANCELLED;
    }

    public void markAsAccepted() {
        this.status = LeaveRequestStatus.ACCEPTED;
    }


}