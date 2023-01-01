package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class DailyLeaveRequest extends LeaveRequest {
    public DailyLeaveRequest(LeaveRequestId leaveRequestId, LeaveRequestType requestType, LeaveRequestDailyPeriod period, ApplicantId applicantId) {
        super(leaveRequestId, requestType, period, applicantId);
    }

    DailyLeaveRequest(WorkInProgress workInProgress) {
        super(workInProgress);
    }

    @Override
    LeaveRequest instance(WorkInProgress workInProgress) {
        return new DailyLeaveRequest(workInProgress);
    }
}
