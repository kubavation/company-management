package com.durys.jakub.companymanagement.absences.leaverequests.domain;

import java.util.Optional;

public interface LeaveRequestRepository {

    Optional<LeaveRequest> load(LeaveRequestId id);

    void save(LeaveRequest leaveRequest);
}