package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.commons.domain.AggregateRoot;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.Getter;

import java.math.BigDecimal;
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


    LeaveRequest markAsSubmitted() {
        this.status = LeaveRequestStatus.SUBMITTED;
        return this;
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
        this.acceptantId = acceptant.id();
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

    void isCompatibleWith(LeaveEntitlements leaveEntitlements) {

    }

    abstract BigDecimal entitledAmountFrom(LeaveEntitlements leaveEntitlements);

    @Getter
    public static class WorkInProgress {
        private LeaveRequestId requestId;
        private LeaveRequestType requestType;
        private LocalDateTime from;
        private LocalDateTime to;
        private LeaveRequestStatus status;

        private AcceptantId acceptantId;
        private ApplicantId applicantId;


        private LeaveEntitlements leaveEntitlements;


        public static WorkInProgress of(LeaveRequestId requestId, LeaveRequestType requestType, LocalDateTime from, LocalDateTime to,
                                        LeaveEntitlements leaveEntitlements) {
            return new WorkInProgress(requestId, requestType, from, to, leaveEntitlements);
        }

        public static WorkInProgress of(LeaveRequestType requestType, LocalDateTime from, LocalDateTime to, LeaveEntitlements leaveEntitlements) {
            return new WorkInProgress(null, requestType, from, to, leaveEntitlements);
        }

        private WorkInProgress(LeaveRequestId requestId, LeaveRequestType requestType,
                               LocalDateTime from, LocalDateTime to,  LeaveEntitlements leaveEntitlements) {
            this.requestId = requestId;
            this.requestType = requestType;
            this.from = from;
            this.to = to;
            this.leaveEntitlements = leaveEntitlements;
        }

        public WorkInProgress inStatus(LeaveRequestStatus status) {
           this.status = status;
           return this;
        }

        public WorkInProgress withAcceptant(AcceptantId acceptantId) {
            this.acceptantId = acceptantId;
            return this;
        }

        public WorkInProgress withApplicant(ApplicantId applicantId) {
            this.applicantId = applicantId;
            return this;
        }

        LeaveRequest submit() {
            return LeaveRequestFactory.create(this)
                    .markAsSubmitted();
        }
    }

}
