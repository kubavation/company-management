package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import com.durys.jakub.companymanagement.request.leave_request.model.enums.LeaveRequestType;

class LeaveRequest {

    private final LeaveRequestId requestId;

    private final LeaveRequestType requestType;

    public LeaveRequest(LeaveRequestId requestId, LeaveRequestType requestType) {
        this.requestId = requestId;
        this.requestType = requestType;
    }
}
