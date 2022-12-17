package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class DailyLeaveRequest extends LeaveRequest {
    public DailyLeaveRequest(LeaveRequestType requestType, LeaveRequestDailyPeriod period, Applicant applicant) {
        super(requestType, period, applicant);
    }
}
