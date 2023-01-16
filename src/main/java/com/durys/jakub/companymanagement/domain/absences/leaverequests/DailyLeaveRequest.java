package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.LeaveEntitlements;
import com.durys.jakub.companymanagement.domain.absences.leaveprivileges.vo.LeaveType;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestType;

import java.math.BigDecimal;

public class DailyLeaveRequest extends LeaveRequest {

    public DailyLeaveRequest(LeaveRequestId leaveRequestId, LeaveRequestType requestType, LeaveRequestDailyPeriod period, ApplicantId applicantId) {
        super(leaveRequestId, requestType, period, applicantId);
    }

    @Override
    BigDecimal entitledAmountFrom(LeaveEntitlements leaveEntitlements) {

        LeaveType leaveType = LeaveType.valueOf(super.getRequestType().getName());

        return leaveEntitlements.daysEntitled(leaveType, super.getPeriod().getTo().toLocalDate());
    }
}
