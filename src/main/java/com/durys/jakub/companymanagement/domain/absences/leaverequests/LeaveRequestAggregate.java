package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Aggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Aggregate
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LeaveRequestAggregate {

    private final LeaveRequestId requestId;

    private LeaveRequestType requestType;

    private final AuthorId authorId;

    private AcceptantId acceptantId;

    private LeaveRequestPeriod period;

    private LeaveRequestStatus status;

    LeaveRequestAggregate(LeaveRequestType requestType, AuthorId authorId, LeaveRequestPeriod period) {
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


    public static class LeaveRequestAggregateBuilder {
        private LeaveRequestId requestId;
        private LeaveRequestType requestType;
        private AuthorId authorId;
        private AcceptantId acceptantId;
        private LeaveRequestPeriod period;
        private LeaveRequestStatus status;

        public LeaveRequestAggregateBuilder builder(LeaveRequestId requestId) {
            this.requestId = requestId;
            return this;
        }

        public LeaveRequestAggregateBuilder requestType(LeaveRequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public LeaveRequestAggregateBuilder author(AuthorId authorId) {
            this.authorId = authorId;
            return this;
        }

        public LeaveRequestAggregateBuilder acceptant(AcceptantId acceptantId) {
            this.acceptantId = acceptantId;
            return this;
        }

        public LeaveRequestAggregateBuilder period(LeaveRequestPeriod period) {
            this.period = period;
            return this;
        }

        public LeaveRequestAggregateBuilder status(LeaveRequestStatus status) {
            this.status = status;
            return this;
        }

        public LeaveRequestAggregate build() {
            return new LeaveRequestAggregate (requestId, requestType, authorId, acceptantId, period, status);
        }

    }




}
