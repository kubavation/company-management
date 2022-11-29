package com.durys.jakub.companymanagement.domain.absences.leaverequests;


import com.durys.jakub.companymanagement.commons.domain.Aggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Aggregate
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class LeaveRequestAggregate {

    private final LeaveRequestId requestId;

    private LeaveRequestType requestType;

    private final Applicant applicant;

    private AcceptantId acceptantId;

    private LeaveRequestPeriod period;

    private LeaveRequestStatus status;

    public LeaveRequestAggregate(LeaveRequestType requestType, Applicant applicant, LeaveRequestPeriod period) {
        this.requestId = new LeaveRequestId(UUID.randomUUID());
        this.requestType = requestType;
        this.applicant = applicant;
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

    public void markAsRejected() {
        this.status = LeaveRequestStatus.REJECTED;
    }


    public static class Builder {
        private LeaveRequestId requestId;
        private LeaveRequestType requestType;
        private Applicant applicant;
        private AcceptantId acceptantId;
        private LeaveRequestPeriod period;
        private LeaveRequestStatus status;

        public Builder(LeaveRequestId requestId) {
            this.requestId = requestId;
        }

        public Builder requestType(LeaveRequestType requestType) {
            this.requestType = requestType;
            return this;
        }

        public Builder applicant(Applicant applicant) {
            this.applicant = applicant;
            return this;
        }

        public Builder acceptant(AcceptantId acceptantId) {
            this.acceptantId = acceptantId;
            return this;
        }

        public Builder period(LeaveRequestPeriod period) {
            this.period = period;
            return this;
        }

        public Builder status(LeaveRequestStatus status) {
            this.status = status;
            return this;
        }

        public LeaveRequestAggregate build() {
            return new LeaveRequestAggregate(requestId, requestType, applicant, acceptantId, period, status);
        }

    }




}
