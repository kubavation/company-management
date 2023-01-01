package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class HourlyLeaveRequest extends LeaveRequest {

    public HourlyLeaveRequest(LeaveRequestId leaveRequestId, LeaveRequestType requestType, LeaveRequestHourlyPeriod period, ApplicantId applicantId) {
        super(leaveRequestId, requestType, period, applicantId);
    }

    public HourlyLeaveRequest(WorkInProgress workInProgress) {
        super(workInProgress);
    }

    @Override
    LeaveRequest instance(WorkInProgress workInProgress) {
        return new HourlyLeaveRequest(workInProgress);
    }
}
