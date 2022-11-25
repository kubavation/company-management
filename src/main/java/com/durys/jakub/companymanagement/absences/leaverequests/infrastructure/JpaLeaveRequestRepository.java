package com.durys.jakub.companymanagement.absences.leaverequests.infrastructure;

import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequest;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestRepository;

import java.util.Optional;

public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    @Override
    public Optional<LeaveRequest> load(LeaveRequestId id) {
        //todo
        return Optional.empty();
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        //todo
    }
}
