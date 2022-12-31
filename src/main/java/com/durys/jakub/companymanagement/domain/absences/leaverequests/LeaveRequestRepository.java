package com.durys.jakub.companymanagement.domain.absences.leaverequests;

public interface LeaveRequestRepository {

    LeaveRequest load(LeaveRequestId id);

    void save(LeaveRequest leaveRequest);
}
