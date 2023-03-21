package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.output;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestId;
import lombok.AllArgsConstructor;

import java.util.HashMap;
import java.util.UUID;

@AllArgsConstructor
public class HashMapLeaveRequestRepository implements LeaveRequestRepository {


    private static HashMap<UUID, LeaveRequest> DB = new HashMap<>();

    @Override
    public LeaveRequest load(LeaveRequestId id) {
        return DB.get(id.value());
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        DB.put(leaveRequest.getRequestId().value(), leaveRequest);
    }

}
