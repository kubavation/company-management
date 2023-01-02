package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

import java.math.BigDecimal;

public class HourlyLeaveRequest extends LeaveRequest {

    public HourlyLeaveRequest(LeaveRequestId leaveRequestId, LeaveRequestType requestType, LeaveRequestHourlyPeriod period, ApplicantId applicantId) {
        super(leaveRequestId, requestType, period, applicantId);
    }

    @Override
    BigDecimal entitledAmountFrom(LeaveEntitlements leaveEntitlements) {

        LeaveType leaveType = LeaveType.valueOf(super.getRequestType().getName());

        return leaveEntitlements.hoursEntitled(leaveType, super.getPeriod().getTo().toLocalDate());
    }
}
