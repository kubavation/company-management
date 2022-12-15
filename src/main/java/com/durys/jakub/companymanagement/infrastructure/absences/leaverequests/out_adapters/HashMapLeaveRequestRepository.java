package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Objects;
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
