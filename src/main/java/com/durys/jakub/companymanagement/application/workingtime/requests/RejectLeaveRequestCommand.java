package com.durys.jakub.companymanagement.application.workingtime.requests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestId;

public record RejectLeaveRequestCommand(LeaveRequestId leaveRequestId) {
}
