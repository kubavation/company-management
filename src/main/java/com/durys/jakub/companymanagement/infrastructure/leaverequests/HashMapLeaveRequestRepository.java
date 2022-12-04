package com.durys.jakub.companymanagement.infrastructure.leaverequests;

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


    private static HashMap<UUID, LeaveRequestAggregate> DB = new HashMap<>();

    @Override
    public LeaveRequestAggregate load(LeaveRequestId id) {
        return DB.get(id.getValue());
    }

    @Override
    public void save(LeaveRequestAggregate leaveRequestAggregate) {
        DB.put(leaveRequestAggregate.getRequestId().getValue(), leaveRequestAggregate);
    }

}
