package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.employees.model.EmployeeId;

public record SendWorkingTimeRequestForAcceptationCommand(LeaveRequestId leaveRequestId, EmployeeId acceptantId) {
}
