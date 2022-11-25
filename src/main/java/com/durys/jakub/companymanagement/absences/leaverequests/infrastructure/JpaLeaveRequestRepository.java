package com.durys.jakub.companymanagement.absences.leaverequests.infrastructure;

import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequest;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.absences.leaverequests.domain.LeaveRequestRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Optional;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Optional<LeaveRequest> load(LeaveRequestId id) {
        return null;
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        //todo
    }
}
