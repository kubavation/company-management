package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public abstract class LeaveRequest {

    private final LeaveRequestId requestId;
    private final LeaveRequestType requestType;
    private final Applicant applicant;

    private Acceptant acceptant;

    private LeaveRequestStatus status;

    public LeaveRequest(LeaveRequestId requestId, LeaveRequestType requestType, Applicant applicant) {
        this.requestId = requestId;
        this.requestType = requestType;
        this.applicant = applicant;
        this.status = LeaveRequestStatus.SUBMITTED;
    }
}
