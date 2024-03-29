package com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.output;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestId;
import com.durys.jakub.companymanagement.infrastructure.absences.leaverequests.LeaveRequestAggregateAssembler;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import java.util.HashMap;
import java.util.Objects;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final LeaveRequestAggregateAssembler leaveRequestAggregateAssembler;

    @Override
    public LeaveRequest load(LeaveRequestId id) {
        LeaveRequestEntity entity = jdbcTemplate.queryForObject("SELECT lr.* FROM CM_LEAVE_REQUEST rl where rl.id = :id",
                new BeanPropertySqlParameterSource(LeaveRequestEntity.class), LeaveRequestEntity.class);

        if (Objects.isNull(entity)) {
            throw new EntityNotFoundException();
        }

        return leaveRequestAggregateAssembler.toAggregate(entity);
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        LeaveRequestEntity entity = leaveRequestAggregateAssembler.toEntity(leaveRequest);
        jdbcTemplate.update("INSERT INTO CM_LEAVE_REQUEST (todo) values (todo)", new HashMap<>());
    }

}
