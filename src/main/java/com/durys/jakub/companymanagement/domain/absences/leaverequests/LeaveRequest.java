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


    protected LeaveRequest(LeaveRequestType requestType, LeaveRequestPeriod period, ApplicantId applicantId) {
        this.requestId = new LeaveRequestId(UUID.randomUUID());
        this.requestType = requestType;
        this.period = period;
        this.applicantId = applicantId;
        this.status = LeaveRequestStatus.SUBMITTED;
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
}
