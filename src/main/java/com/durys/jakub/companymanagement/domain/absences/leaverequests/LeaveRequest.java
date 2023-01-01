package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.acceptant.Acceptant;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.acceptant.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Getter
@AggregateRoot
abstract class LeaveRequest {

    private final LeaveRequestId requestId;
    private final LeaveRequestType requestType;
    private final LeaveRequestPeriod period;
    private LeaveRequestStatus status;

    private final ApplicantId applicantId;

    private AcceptantId acceptantId;


    protected LeaveRequest(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period, ApplicantId applicantId) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.period = period;
        this.applicantId = applicantId;
    }

    LeaveRequest(LeaveRequest.Builder builder) {
        this(builder.requestId, builder.requestType, builder.period, builder.applicantId);
        this.status = builder.status;
        this.acceptantId = builder.acceptantId;
    }


    LeaveRequest markAsSubmitted(LeaveRequest.Builder builder) {
        builder
            .inStatus(LeaveRequestStatus.SUBMITTED);
        return instance(builder);
    }

    void markAsDeleted() {

        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.DELETED;
    }

    void setAcceptant(Acceptant acceptant) {

        Objects.requireNonNull(acceptant, "You have to provide acceptant");

        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.SEND_FOR_ACCEPTATION;
        this.acceptantId = acceptant.getAccptantId();
    }

    void markAsCancelled() {

        if (status == LeaveRequestStatus.DELETED) {
            throw new InvalidStatusForOperationException();
        }

        if (LocalDateTime.now().isAfter(period.getFrom())) {
            throw new OperationUnavailableException();
        }

        this.status = LeaveRequestStatus.CANCELLED;
    }

    void markAsAccepted() {

        if (status != LeaveRequestStatus.SEND_FOR_ACCEPTATION) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.ACCEPTED;
    }

    void markAsRejected() {
        this.status = LeaveRequestStatus.REJECTED;
    }

    abstract LeaveRequest instance(LeaveRequest.Builder builder);

    public static class Builder {
        private LeaveRequestId requestId;
        private LeaveRequestType requestType;
        private LeaveRequestPeriod period;
        private LeaveRequestStatus status;

        private AcceptantId acceptantId;
        private ApplicantId applicantId;

        public Builder of(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
            return new Builder(requestId, requestType, period);
        }

        public Builder of(LeaveRequestType requestType, LeaveRequestPeriod period) {
            return new Builder(null, requestType, period);
        }

        private Builder(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
            this.requestId = requestId;
            this.requestType = requestType;
            this.period = period;
        }

        public Builder inStatus(LeaveRequestStatus status) {
           this.status = status;
           return this;
        }

        public Builder withAcceptant(AcceptantId acceptantId) {
            this.acceptantId = acceptantId;
            return this;
        }
    }

}
