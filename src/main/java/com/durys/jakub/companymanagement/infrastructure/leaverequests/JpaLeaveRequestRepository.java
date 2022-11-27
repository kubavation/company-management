package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final LeaveRequestAggregateAssembler leaveRequestAggregateAssembler;

    @Override
    public LeaveRequest load(LeaveRequestId id) {
        LeaveRequestEntity entity =  jdbcTemplate.queryForObject(
                "SELECT lr.* FROM CM_LEAVE_REQUEST rl where id = :id",
                new BeanPropertySqlParameterSource(LeaveRequestEntity.class), LeaveRequestEntity.class);

        return leaveRequestAggregateAssembler.toAggregate(entity);
    }

    @Override
    public void save(LeaveRequest leaveRequest) {
        //todo
    }

}
