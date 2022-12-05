package com.durys.jakub.companymanagement.infrastructure.leaverequests.out_adapters;

import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestRepository;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.infrastructure.leaverequests.LeaveRequestAggregateAssembler;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.Objects;

@AllArgsConstructor
public class JpaLeaveRequestRepository implements LeaveRequestRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final LeaveRequestAggregateAssembler leaveRequestAggregateAssembler;

    @Override
    public LeaveRequestAggregate load(LeaveRequestId id) {
        LeaveRequestEntity entity =  jdbcTemplate.queryForObject("SELECT lr.* FROM CM_LEAVE_REQUEST rl where rl.id = :id",
                new BeanPropertySqlParameterSource(LeaveRequestEntity.class), LeaveRequestEntity.class);

        if (Objects.isNull(entity)) {
            throw new EntityNotFoundException();
        }

        return leaveRequestAggregateAssembler.toAggregate(entity);
    }

    @Override
    public void save(LeaveRequestAggregate leaveRequestAggregate) {
        LeaveRequestEntity entity = leaveRequestAggregateAssembler.toEntity(leaveRequestAggregate);
        jdbcTemplate.update("INSERT INTO CM_LEAVE_REQUEST (todo) values (todo)", new HashMap<>());
    }

}
