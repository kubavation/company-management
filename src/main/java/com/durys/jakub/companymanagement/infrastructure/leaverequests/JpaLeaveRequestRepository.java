package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final LeaveRequestDAO leaveRequestDAO;

    @Override
    public LeaveRequest load(LeaveRequestId id) {
        return leaveRequestDAO.getById(id.getValue());
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        //todo
    }
}
