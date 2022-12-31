package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class HourlyLeaveRequest extends LeaveRequest {

    public HourlyLeaveRequest(LeaveRequestType requestType, LeaveRequestHourlyPeriod period, ApplicantId applicantId) {
        super(requestType, period, applicantId);
    }
}
