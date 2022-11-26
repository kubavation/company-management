package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public LeaveRequest load(LeaveRequestId id) {
        return null;
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        //todo
    }

}
