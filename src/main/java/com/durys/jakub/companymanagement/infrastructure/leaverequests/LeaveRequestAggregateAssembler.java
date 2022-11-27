package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestAggregateAssembler implements AggregateAssembler<LeaveRequestEntity, LeaveRequestAggregate> {


    @Override
    public LeaveRequestEntity toEntity(LeaveRequestAggregate aggregate) {
        return null;
    }

    @Override
    public LeaveRequestAggregate toAggregate(LeaveRequestEntity entity) {
        return null;
    }
}
