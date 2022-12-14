package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.InvalidStatusForOperationException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.exception.OperationUnavailableException;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
public abstract class LeaveRequest {

    private final LeaveRequestId requestId;
    private final LeaveRequestType requestType;

    private LeaveRequestPeriod period;
    private Acceptant acceptant;

    private LeaveRequestStatus status;

    public LeaveRequest(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.period = period;
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

        if (LocalDateTime.now().isAfter(period.getDateFrom())) {
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
