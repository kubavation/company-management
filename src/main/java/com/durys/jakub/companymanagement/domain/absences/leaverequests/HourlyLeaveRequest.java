package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class HourlyLeaveRequest extends LeaveRequest {

    public HourlyLeaveRequest(LeaveRequestId leaveRequestId, LeaveRequestType requestType, LeaveRequestHourlyPeriod period, ApplicantId applicantId) {
        super(leaveRequestId, requestType, period, applicantId);
    }

    public HourlyLeaveRequest(Builder builder) {
        super(builder);
    }

    @Override
    LeaveRequest instance(LeaveRequest.Builder builder) {
        return new HourlyLeaveRequest(builder);
    }
}
