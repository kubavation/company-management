package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequest;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestAggregateAssembler implements AggregateAssembler<LeaveRequestEntity, LeaveRequest> {


    @Override
    public LeaveRequestEntity toEntity(LeaveRequest aggregate) {
        return null;
    }

    @Override
    public LeaveRequest toAggregate(LeaveRequestEntity entity) {
        return null;
    }
}
