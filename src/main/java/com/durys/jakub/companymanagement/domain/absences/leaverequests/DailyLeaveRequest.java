package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

public class DailyLeaveRequest extends LeaveRequest {
    public DailyLeaveRequest(LeaveRequestId requestId, LeaveRequestType requestType, LeaveRequestPeriod period) {
        super(requestId, requestType, period);
    }
}
