package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@AggregateRoot
public abstract class LeaveRequest {

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

    LeaveRequest(WorkInProgress workInProgress) {
        this(workInProgress.requestId, workInProgress.requestType, workInProgress.period, workInProgress.applicantId);
        this.status = workInProgress.status;
        this.acceptantId = workInProgress.acceptantId;
    }


    LeaveRequest markAsSubmitted(WorkInProgress workInProgress) {
        return workInProgress
            .inStatus(LeaveRequestStatus.SUBMITTED)
            .instance();
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

    abstract LeaveRequest instance(WorkInProgress workInProgress);

    @Getter
    public static class WorkInProgress {
        private LeaveRequestId requestId;
        private LeaveRequestType requestType;
        private LeaveRequestPeriod period;
        private LeaveRequestStatus status;

        private AcceptantId acceptantId;
        private ApplicantId applicantId;

        public WorkInProgress of(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
            return new WorkInProgress(requestId, requestType, period);
        }

        public WorkInProgress of(LeaveRequestType requestType, LeaveRequestPeriod period) {
            return new WorkInProgress(null, requestType, period);
        }

        private WorkInProgress(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
            this.requestId = requestId;
            this.requestType = requestType;
            this.period = period;
        }

        public WorkInProgress inStatus(LeaveRequestStatus status) {
           this.status = status;
           return this;
        }

        public WorkInProgress withAcceptant(AcceptantId acceptantId) {
            this.acceptantId = acceptantId;
            return this;
        }

        LeaveRequest instance() {
            return LeaveRequestFactory.create(this);
        }
    }

}
