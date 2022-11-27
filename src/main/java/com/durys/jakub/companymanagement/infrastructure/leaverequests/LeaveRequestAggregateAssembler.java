package com.durys.jakub.companymanagement.infrastructure.leaverequests;

import com.durys.jakub.companymanagement.commons.AggregateAssembler;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestAggregate;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.LeaveRequestPeriod;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AcceptantId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.AuthorId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestId;
import com.durys.jakub.companymanagement.domain.absences.leaverequests.vo.LeaveRequestStatus;
import org.springframework.stereotype.Component;

@Component
public class LeaveRequestAggregateAssembler implements AggregateAssembler<LeaveRequestEntity, LeaveRequestAggregate> {


    @Override
    public LeaveRequestEntity toEntity(LeaveRequestAggregate aggregate) {
        return LeaveRequestEntity.builder()
                .id(aggregate.getRequestId().value())
                .requestStatus(aggregate.getStatus())
                .employeeId(aggregate.getAuthorId().id())
                .acceptingId(aggregate.getAcceptantId().id())
                .dateFrom(aggregate.getPeriod().getDateFrom())
                .dateTo(aggregate.getPeriod().getDateTo())
                .type(aggregate.getRequestType())
                .build();
    }

    @Override
    public LeaveRequestAggregate toAggregate(LeaveRequestEntity entity) {
        return new LeaveRequestAggregate.Builder(new LeaveRequestId(entity.getId()))
                .author(new AuthorId(entity.getEmployeeId()))
                .acceptant(new AcceptantId(entity.getAcceptingId()))
                .period(new LeaveRequestPeriod(entity.getDateFrom(), entity.getDateTo()))
                .status(entity.getRequestStatus())
                .requestType(entity.getType())
                .build();

    }
}
