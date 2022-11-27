package com.durys.jakub.companymanagement.domain.absences.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;

public interface LeaveRequestRepository {

    LeaveRequestAggregate load(LeaveRequestId id);

    void save(LeaveRequestAggregate leaveRequestAggregate);
}
