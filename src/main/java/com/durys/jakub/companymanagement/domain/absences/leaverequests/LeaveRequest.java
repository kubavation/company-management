package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;


@Getter
public abstract class LeaveRequest {

    private final LeaveRequestId requestId;
    private final LeaveRequestType requestType;

    private LeaveRequestPeriod period;

    private final Applicant applicant;

    private final ApplicantId applicantId;

    private final AcceptantId acceptantId;

    private Acceptant acceptant;
    private LeaveRequestStatus status;


    protected LeaveRequest(LeaveRequestType requestType, LeaveRequestPeriod period, Applicant applicant) {
        this.requestId = new LeaveRequestId(UUID.randomUUID());
        this.requestType = requestType;
        this.period = period;
        this.applicant = applicant;
        this.status = LeaveRequestStatus.SUBMITTED;
    }

    void markAsDeleted() {

        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.DELETED;
    }

    void sendToAcceptant(Acceptant acceptant) {

        Objects.requireNonNull(acceptant, "You have to provide acceptant");

        if (status != LeaveRequestStatus.SUBMITTED) {
            throw new InvalidStatusForOperationException();
        }

        this.status = LeaveRequestStatus.SEND_FOR_ACCEPTATION;
        this.acceptant = acceptant;
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
